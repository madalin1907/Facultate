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
    pattern: "{controller=GiftCards}/{action=Index}");

app.MapControllerRoute(
    name: "new_giftcard",
    pattern: "{controller=GiftCards}/{action=New}");

app.MapControllerRoute(
    name: "delete_giftcard",
    pattern: "{controller=GiftCards}/{action=Delete}/{id?}");

app.MapControllerRoute(
    name: "delete_giftcard",
    pattern: "{controller=GiftCards}/{action=Edit}/{id?}");

app.MapControllerRoute(
    name: "show_giftcard",
    pattern: "{controller=GiftCards}/{action=Show}/{id?}");



app.Run();
