<h1>Desenvolvimento do projeto Viajabessa.</h1>

<img src="https://raw.githubusercontent.com/marcellogalhardo/Viajabessa/master/app/src/main/res/mipmap-xxxhdpi/ic_launcher.png"> </img>

1. Estrutura do projeto.

 Durante o desenvolvimento foi utilizado a seguinte estrutura:
 - Events: Pacote responsável pelos eventos customizados internos do APP.
 - Models: Pacote com os modelos de dados.
 - Services: Classes que acessam e consomem os serviços (webservice com mock).
 - Tasks: Tasks que são executadas fora da Ui Thread; AsyncTask.
 - Ui: Pacote com a responsabilidade de manipulação da View (ModelView).
 -- Activities.
 -- Fragments.
 -- Adapters: ListView Adapters.
 - Utils: Classes utilitárias.

2. Frameworks utilizados:

 - Otto: Para utilizar eventos personalizados.
 - OrmLite: Para persistência no banco de dados SQLite.
 - Retrofit: Para consumir o webservice com mock RestFull.
 - Butterknife: Para injetar as views.
