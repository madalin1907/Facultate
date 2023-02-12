using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using ModelExamen.Models;

namespace ModelExamen.Controllers
{   
    public class GiftCardsController : Controller
    {
        private readonly AppDbContext _db;

        public GiftCardsController(AppDbContext context)
        {
            _db = context;
        }

        [NonAction]
        public IEnumerable<SelectListItem> GetAllBrands()
        {
            {
                var selectList = new List<SelectListItem>();

                var brands = from brand in _db.Brands
                             select brand;

                foreach (var brand in brands)
                {
                    selectList.Add(new SelectListItem
                    {
                        Value = brand.Id.ToString(),
                        Text = brand.Nume?.ToString()
                    });
                }

                return selectList;
            }
        }

        public IActionResult Index()
        {
            var giftCards = _db.GiftCards.Include("Brand").ToList();
            if (TempData.ContainsKey("message"))
            {
                ViewBag.Message = TempData["message"];
            }
            ViewBag.GiftCards = giftCards;
            return View();
        }

        public IActionResult New()
        {
            var giftCard = new GiftCard();
            giftCard.Brands = GetAllBrands();
            return View(giftCard);
        }

        [HttpPost]
        public IActionResult New(GiftCard giftCard)
        {
            if (giftCard.DataExp <= DateTime.Now)
            {
                ModelState.AddModelError("DataExp", "Data de expirare trebuie sa fie mai mare decat data curenta!");
                return View(giftCard);
            }
            
            giftCard.Brands = GetAllBrands();

            if (ModelState.IsValid)
            {
                _db.GiftCards.Add(giftCard);
                _db.SaveChanges();
                TempData["message"] = "Cardul a fost adaugat";
                return RedirectToAction("Index");
            }
           
            return View(giftCard);
        }

        [HttpPost]
        public IActionResult Delete(int? id)
        {
            var giftCard = _db.GiftCards.Find(id);
            if (giftCard != null)
            {
                _db.GiftCards.Remove(giftCard);
                _db.SaveChanges();
            }
            return RedirectToAction("Index");
        }

        
        public IActionResult Edit(int? id)
        {
            var giftCard = _db.GiftCards.Find(id);
            if (giftCard == null)
            {
                return RedirectToAction("Index");
            }

            giftCard.Brands = GetAllBrands();
            return View(giftCard);
        }

        [HttpPost]
        public IActionResult Edit(int? id, GiftCard editedGiftCard)
        {
            var giftCard = _db.GiftCards.Find(id);

            if (giftCard == null)
            {
                return RedirectToAction("Index");
            }

            giftCard.Brands = GetAllBrands();

            if (editedGiftCard.DataExp <= DateTime.Now)
            {
                ModelState.AddModelError("DataExp", "Data de expirare trebuie sa fie mai mare decat data curenta!");
                return View(giftCard);
            }

            if (ModelState.IsValid)
            {
                giftCard.Denumire = editedGiftCard.Denumire;
                giftCard.Descriere = editedGiftCard.Descriere;
                giftCard.BrandId = editedGiftCard.BrandId;
                giftCard.DataExp = editedGiftCard.DataExp;
                giftCard.Procent = editedGiftCard.Procent;
                _db.SaveChanges();

                return RedirectToAction("Index");
            }

            return View(giftCard);
        }


        public IActionResult Show(int? id)
        {
            var giftCard = _db.GiftCards.Find(id);
            var brand = _db.Brands.Find(giftCard?.BrandId);

            if (giftCard == null)
            {
                return RedirectToAction("Index");
            }

            ViewBag.Giftcard = giftCard;
            ViewBag.Brand = brand.Nume;
            return View();
        }


        public IActionResult Search(string? searchValue)
        {
            var giftCards = _db.GiftCards.Include("Brand").ToList();
            var newGiftCards = new List<GiftCard>();
            
            if (searchValue != null)
            {
                giftCards = giftCards.Where(g => g.Denumire?.ToLower().Contains(searchValue.ToLower()) == true).ToList();
            }

            foreach (var giftCard in giftCards)
            {
                if (giftCard.DataExp != null && giftCard.DataExp.Value.Subtract(DateTime.Now).Days <= 5 && giftCard.Procent >= 30)
                {
                    newGiftCards.Add(giftCard);
                }
            }

            newGiftCards.Sort((x, y) => DateTime.Compare(y.DataExp ?? DateTime.Now, x.DataExp ?? DateTime.Now));

            ViewBag.GiftCards = newGiftCards;
            return View();
        }
    }
}
