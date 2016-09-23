# OPN Repository

## Webservices
I folderen [ws](opn/ws/) findes der et udvalg af webservice/web api implementationer 

### BankingDotNetCore
Dette Web API kræver dotnet core som kan downloades her: [.NET Core SDK](https://go.microsoft.com/fwlink/?LinkID=827524)
Hvis man ønsker at bruge Visual Studio, kan der læses mere [her](https://www.microsoft.com/net/core#windows)

Efter installation af .NET Core SDK, kan projektet enten startes fra Visual Studio 2015 eller kommandolinjen.
På kommandolinjen navigeres der til projektet rod-folder, [som ses her](opn/ws/BankingDotNetCore/)

```
dotnet restore
dotnet run
```

#### Hosted web API
På [dotnetcore.nbo.codes/api/bank](http://dotnetcore.ws.nbo.codes/api/bank) kører .NET Core web API'et og kan benyttes til at arbejde op imod fra lokale klient programmer.

