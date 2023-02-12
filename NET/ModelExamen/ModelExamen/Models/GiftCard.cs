using Microsoft.AspNetCore.Mvc.Rendering;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ModelExamen.Models
{
    public class GiftCard
    {
        [Key]
        public int Id { get; set; }
        
        [Required(ErrorMessage = "Denumirea este obligatorie!")]
        public string? Denumire { get; set; }
        
        [Required(ErrorMessage = "Descrierea este obligatorie!")]
        public string? Descriere { get; set; }
        
        [Required(ErrorMessage = "Data de expirare este obligatorie"!)]
        public DateTime? DataExp { get; set; }

        [Required(ErrorMessage = "Procentul este obligatoriu!")]
        [Range(1, 100, ErrorMessage = "Procentul trebuie sa fie intre 1 si 100!")]
        public int? Procent { get; set; }

        [Required(ErrorMessage = "Brandul este obligatoriu!")]
        public int? BrandId { get; set; }

        public Brand? Brand { get; set; }

        [NotMapped]
        public IEnumerable<SelectListItem>? Brands { get; set; }
    }
}
