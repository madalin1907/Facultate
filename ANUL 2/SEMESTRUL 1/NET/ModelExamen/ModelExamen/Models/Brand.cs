using System.ComponentModel.DataAnnotations;

namespace ModelExamen.Models
{
    public class Brand
    {
        [Key]
        public int Id { get; set; }
        public string? Nume { get; set; }
    }
}
