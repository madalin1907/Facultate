using Microsoft.AspNetCore.Mvc.Rendering;
using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace FloreaMadalinA43.Models
{
    public class Ticket
    {
        [Key]
        public int Id { get; set; }

        [Required(ErrorMessage = "Titlul biletului este obligatoriu!")]
        [StringLength(10, ErrorMessage = "Titlul poate avea maxim 10 caractere!")]
        public string? TitluBilet { get; set; }

        [Required(ErrorMessage = "Pretul biletului este obligatoriu!")]
        [Range(1, int.MaxValue, ErrorMessage = "Pretul trebuie sa fie pozitiv!")]
        public int? Pret { get; set; }

        [Required(ErrorMessage = "Data este obligatorie"!)]
        public DateTime? Data { get; set; }


        [Required(ErrorMessage = "Filmul este obligatoriu!")]
        public int? MovieId { get; set; }

        public Movie? Movie { get; set; }
        
        [NotMapped]
        public IEnumerable<SelectListItem>? Movies { get; set; }
    }
}