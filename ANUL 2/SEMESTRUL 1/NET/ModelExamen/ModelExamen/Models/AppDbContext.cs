using Microsoft.EntityFrameworkCore;
using ModelExamen.Models;

public class AppDbContext : DbContext
{
    public AppDbContext(DbContextOptions<AppDbContext>
    options)
     : base(options)
    {
    }

    public DbSet<Brand> Brands { get; set; }
    public DbSet<GiftCard> GiftCards { get; set; }
}