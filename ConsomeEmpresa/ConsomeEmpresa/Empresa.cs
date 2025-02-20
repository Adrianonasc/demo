using System.Text.Json.Serialization;

namespace ConsomeEmpresa
{
	public record Empresa
	{
		[JsonPropertyName("cnpj")]
		public required string CNPJ { get; set; }

		[JsonPropertyName("nomeEmpresa")]
		public required string NomeEmpresa { get; set; }
	}
}
