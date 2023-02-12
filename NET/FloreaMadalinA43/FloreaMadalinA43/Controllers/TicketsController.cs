using FloreaMadalinA43.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;

namespace FloreaMadalinA43.Controllers
{
    public class TicketsController : Controller
    {
        private readonly AppDbContext _db;

        public TicketsController(AppDbContext context)
        {
            _db = context;
        }

        [NonAction]
        public IEnumerable<SelectListItem> GetAllMovies()
        {
            {
                var selectList = new List<SelectListItem>();

                var movies = from movie 
                             in _db.Movies
                             select movie;
                
                foreach (var movie in movies)
                {
                    selectList.Add(new SelectListItem
                    {
                        Value = movie.Id.ToString(),
                        Text = movie.DenFilm?.ToString()
                    });
                }

                return selectList;
            }
        }


        // afisarea tuturor biletelor
        public IActionResult Index()
        {
            var tickets = _db.Tickets.Include("Movie").ToList();
            
            if (TempData.ContainsKey("message"))
            {
                ViewBag.Message = TempData["message"];
            }
            
            ViewBag.Tickets = tickets;
            
            return View();
        }


        // afisarea unui singur bilet
        public IActionResult Show(int? id)
        {
            var ticket = _db.Tickets.Find(id);
            var movie = _db.Movies.Find(ticket?.MovieId);

            if (ticket == null)
            {
                return RedirectToAction("Index");
            }

            ViewBag.Ticket= ticket;
            ViewBag.Movie = movie.DenFilm;
            return View();
        }


        // stergerea unui bilet
        [HttpPost]
        public IActionResult Delete(int? id)
        {
            var ticket = _db.Tickets.Find(id);
            if (ticket != null)
            {
                _db.Tickets.Remove(ticket);
                _db.SaveChanges();
            }
            return RedirectToAction("Index");
        }


        // editarea unui bilet
        public IActionResult Edit(int? id)
        {
            var ticket = _db.Tickets.Find(id);
            if (ticket == null)
            {
                return RedirectToAction("Index");
            }

            ticket.Movies = GetAllMovies();
            return View(ticket);
        }

        [HttpPost]
        public IActionResult Edit(int? id, Ticket newTicket)
        {
            var ticket = _db.Tickets.Find(id);

            if (ticket == null)
            {
                return RedirectToAction("Index");
            }

            ticket.Movies = GetAllMovies();

            if (newTicket.Data <= DateTime.Now)
            {
                ModelState.AddModelError("Data", "Data trebuie sa fie mai mare decat data curenta!");
                return View(ticket);
            }

            if (ModelState.IsValid)
            {
                ticket.TitluBilet = newTicket.TitluBilet;
                ticket.Pret = newTicket.Pret;
                ticket.Data = newTicket.Data;
                ticket.MovieId = newTicket.MovieId;
                
                _db.SaveChanges();
                TempData["message"] = "Biletul a fost modificat cu succes.";
                return RedirectToAction("Index");
            }

            return View(ticket);
        }


        // adaugarea unui bilet
        public IActionResult New()
        {
            var ticket = new Ticket();
            ticket.Movies = GetAllMovies();
            return View(ticket);
        }

        [HttpPost]
        public IActionResult New(Ticket ticket)
        {
            ticket.Movies = GetAllMovies();

            if (ModelState.IsValid)
            {
                if (ticket.Data <= DateTime.Now)
                {
                    ModelState.AddModelError("Data", "Data trebuie sa fie mai mare decat data curenta!");
                    return View(ticket);
                }

                _db.Tickets.Add(ticket);
                _db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(ticket);
        }


        // functioneaza dar by default si cand searchInput este null nu afiseaza mesaj, ci gaseste toate filmele din lista
        public IActionResult Search(string? searchInput)
        {
            var tickets = _db.Tickets.Include("Movie").ToList();
            

            if (searchInput != null)
            {
                tickets = tickets.Where(t => t.Movie.DenFilm?.ToLower().Contains(searchInput.ToLower()) == true).ToList();
            }
            

            var sum = 0;
            foreach (var ticket in tickets)
            {
                sum += ticket.Pret ?? default(int);
            }


            if (tickets.Count != 0)
                ViewBag.Mesaj = "S-au vandut bilete in valoare de " + sum + " lei.";
            else
                ViewBag.Mesaj = "Filmul cautat nu exista";


            ViewBag.Tickets = tickets;
            return View();
        }
    }
}
