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

 - Otto: Para utilizar eventos personalizados (https://github.com/square/otto).
 - OrmLite: Para persistência no banco de dados SQLite (http://ormlite.com/).
 - Retrofit: Para consumir o webservice com mock RestFull (http://square.github.io/retrofit/).
 - Butterknife: Para injetar as views (http://jakewharton.github.io/butterknife/).
 - Picasso + OkHttp (+ okhttp-urlconnection): Para obter as imagens, criar caches em memória e em disco (http://square.github.io/picasso/ e http://square.github.io/okhttp/).
 
<h2>3. Considerações:</h2>

- Documentação da API do Viajabessa (Mock): http://docs.mobicareviajabessa.apiary.io/
- Para carregar novos dados do servidor, basta usar o "pull to refresh" na listview de pacotes.
- O ServiceFactory, que tem como responsabilidade criar os objetos já configurados que irão consumir os serviços (mock) utiliza um requestInterceptor para enviar o User-Agent, Device-Version, Device-Model e Device-Manufacturer em cada request pelo header (para o Marketing ter acesso as informações do celular do usuário).
- Esquema de cores de acordo com o material design colors (http://www.google.com/design/spec/style/color.html).

<h3>4. Imagens do aplicativo (tela grande):</h3>

<img src="https://raw.githubusercontent.com/marcellogalhardo/Viajabessa/master/screenshot/tela_grande/Screenshot_2015-03-15-15-13-01.png"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_grande/Screenshot_2015-03-15-15-13-18.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_grande/Screenshot_2015-03-15-15-13-31.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_grande/Screenshot_2015-03-15-15-13-36.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_grande/Screenshot_2015-03-15-15-13-46.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_grande/Screenshot_2015-03-15-15-13-58.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_grande/Screenshot_2015-03-15-15-14-10.png?raw=true"></img>

<h3>5. Imagens do aplicativo (tela pequena):</h3>

<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_pequena/Screenshot_2015-03-15-22-47-38.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_pequena/Screenshot_2015-03-15-22-47-53.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_pequena/Screenshot_2015-03-15-22-48-17.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_pequena/Screenshot_2015-03-15-22-48-31.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_pequena/Screenshot_2015-03-15-22-49-37.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_pequena/Screenshot_2015-03-15-22-49-42.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_pequena/Screenshot_2015-03-15-22-49-44.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_pequena/Screenshot_2015-03-15-22-49-50.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/tela_pequena/Screenshot_2015-03-15-22-50-05.png?raw=true"></img>

<h3>6. Imagens do aplicativo (Android 2.3.3):</h3>

<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/android_2_3_3/device-2015-03-15-232410.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/android_2_3_3/device-2015-03-15-232429.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/android_2_3_3/device-2015-03-15-232448.png?raw=true"></img>
<img src="https://github.com/marcellogalhardo/Viajabessa/blob/master/screenshot/android_2_3_3/device-2015-03-15-232500.png?raw=true"></img>
