// See https://aka.ms/new-console-template for more information
using Bogus;
using Bogus.Extensions.Brazil;
using ConsomeEmpresa;
using System.Text;
using System.Text.Json;

var lorem = new Bogus.DataSets.Lorem(locale: "pt_BR");
var faker = new Faker("pt_BR");

faker.Company.Cnpj();
var fakers = new Faker<Empresa>("pt_BR")
					.RuleFor(e => e.CNPJ, f => f.Company.Cnpj(false))
					.RuleFor(e => e.NomeEmpresa, f => f.Company.CompanyName())
					.Generate(100000);

HttpClient sharedClient = new()
{
	BaseAddress = new Uri("http://localhost:8080"),
};

sharedClient.DefaultRequestHeaders.Add("Accept", "application/json");
var options = new ParallelOptions()
{
	MaxDegreeOfParallelism = 10,
};

await Parallel.ForEachAsync(fakers, options, async (item, ct) =>
{
	try
	{
		await sharedClient.PostAsync("empresa", new StringContent(JsonSerializer.Serialize(item), Encoding.UTF8, "application/json"));
		Console.WriteLine($"200 {ct}");
		//Thread.Sleep(1000);
	}
	catch (Exception)
	{
		Console.WriteLine($"500 {ct}");
	}

});

//foreach (var item in fakers)
//{
//	try
//	{
//		await sharedClient.PostAsync("empresa", new StringContent(JsonSerializer.Serialize(item), Encoding.UTF8, "application/json"));
//		Console.WriteLine("200");
//		Thread.Sleep(1000);
//	}
//	catch (Exception)
//	{
//		Console.WriteLine("500");
//	}
//}
