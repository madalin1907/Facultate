using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllersWithViews();

var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");
builder.Services.AddDbContext<AppDbContext>(options => options.UseSqlServer(connectionString));

var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.MapControllerRoute(
    name: "show_tickets",
    pattern: "{controller=Tickets}/{action=Index}");

app.MapControllerRoute(
    name: "show_ticket",
    pattern: "{controller=Tickets}/{action=Show}/{id?}");

app.MapControllerRoute(
    name: "delete_ticket",
    pattern: "{controller=Tickets}/{action=Delete}/{id?}");

app.MapControllerRoute(
    name: "edit_ticket",
    pattern: "{controller=Tickets}/{action=Edit}/{id?}");

app.MapControllerRoute(
    name: "new_ticket",
    pattern: "{controller=Tickets}/{action=New}");


app.Run();
