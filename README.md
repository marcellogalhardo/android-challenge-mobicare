<h1>Desenvolvimento do projeto Viajabessa.</h1>

<img src="https://raw.githubusercontent.com/marcellogalhardo/Viajabessa/master/app/src/main/res/mipmap-xxxhdpi/ic_launcher.png"> </img>

<h2>1. Estrutura do projeto.</h2>

 - Events: Pacote responsável pelos eventos customizados internos do APP.
 - Models: Pacote com os modelos de dados.
 - Services: Classes que acessam e consomem os serviços (webservice com mock).
 - Tasks: Tasks que são executadas fora da Ui Thread; AsyncTask.
 - Ui: Pacote com a responsabilidade de manipulação da View (ModelView).
 - Ui.Activities.
 - Ui.Fragments.
 - Ui.Adapters: ListView Adapters.
 - Utils: Classes utilitárias.

<h2>2. Frameworks utilizados:</h2>

 - Otto: Para utilizar eventos personalizados.
 - OrmLite: Para persistência no banco de dados SQLite.
 - Retrofit: Para consumir o webservice com mock RestFull.
 - Butterknife: Para injetar as views.
 - Picasso + OkHttp (+ okhttp-urlconnection): Para obter as imagens, criar caches em memória e em disco.
 
<h2>3. Considerações:</h2>

- Para carregar novos dados do servidor, basta usar o "pull to refresh" na listview de pacotes.
- O ServiceFactory, que tem como responsabilidade criar os objetos já configurados que irão consumir os serviços (mock) utiliza um requestInterceptor para enviar o User-Agent, Device-Version, Device-Model e Device-Manufacturer em cada request pelo header.

<h3>4. Imagens do aplicativo:</h3>

<img src="https://raw.githubusercontent.com/marcellogalhardo/Viajabessa/master/screenshot/Screenshot_2015-03-15-15-13-01.png"></img>
<img src="https://raw.githubusercontent.com/marcellogalhardo/Viajabessa/master/screenshot/Screenshot_2015-03-15-15-13-18.png"></img>
<img src="https://raw.githubusercontent.com/marcellogalhardo/Viajabessa/master/screenshot/Screenshot_2015-03-15-15-13-31.png"></img>
<img src="https://raw.githubusercontent.com/marcellogalhardo/Viajabessa/master/screenshot/Screenshot_2015-03-15-15-13-36.png"></img>
<img src="https://raw.githubusercontent.com/marcellogalhardo/Viajabessa/master/screenshot/Screenshot_2015-03-15-15-13-46.png"></img>
<img src="https://raw.githubusercontent.com/marcellogalhardo/Viajabessa/master/screenshot/Screenshot_2015-03-15-15-13-58.png"></img>
<img src="https://raw.githubusercontent.com/marcellogalhardo/Viajabessa/master/screenshot/Screenshot_2015-03-15-15-14-10.png"></img>
