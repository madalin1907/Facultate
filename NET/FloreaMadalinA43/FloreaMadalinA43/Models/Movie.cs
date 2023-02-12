using System.ComponentModel.DataAnnotations;

namespace FloreaMadalinA43.Models
{
    public class Movie
    {
        [Key]
        public int Id { get; set; }
        public string? DenFilm { get; set; }
    }
}
