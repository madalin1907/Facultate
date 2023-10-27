using Microsoft.EntityFrameworkCore;
using FloreaMadalinA43.Models;

public class AppDbContext : DbContext
{
    public AppDbContext(DbContextOptions<AppDbContext>
    options)
     : base(options)
    {
    }

    public DbSet<Movie> Movies { get; set; }
    public DbSet<Ticket> Tickets { get; set; }
}