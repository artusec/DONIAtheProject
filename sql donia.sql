-- ESTO ES UN SCRIPT PARA INICIALIZAR LA DB DE DONIA
-- version final

-- PASOS A SEGUIR:
-- En mariaDB, crear base de datos con nombre 'donia'
-- conectarse a la misma y crear usuario 'usr' con clave 'usr'
-- Este mismo script le dara privilegios al usuario creado
-- (Observación: Los nombres obviamente sin comillas)

DROP TABLE `rusuariogenero`;
DROP TABLE `rlistacancion`;
DROP TABLE `cancion`;
DROP TABLE `video`;
DROP TABLE `letra`;
DROP TABLE `biblioteca`;
DROP TABLE `listaauto`;
DROP TABLE `genero`;
DROP TABLE `listanormal`;
DROP TABLE `lista`;
DROP TABLE `usuarioadmin`;
DROP TABLE `usuario`;

CREATE TABLE `usuario` (
  `usuario` varchar(100) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `clave` varchar(100) NOT NULL,
  PRIMARY KEY (`usuario`)
);

CREATE TABLE `usuarioadmin` (
  `usuario` varchar(100) NOT NULL,
  PRIMARY KEY (`usuario`),
  CONSTRAINT `usuarioadmin_usuario_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `lista` (
  `lista` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`lista`)
);

CREATE TABLE `listanormal` (
  `lista` varchar(100) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  PRIMARY KEY (`lista`),
  KEY `listanormal_usuario_FK` (`usuario`),
  CONSTRAINT `listanormal_lista_FK` FOREIGN KEY (`lista`) REFERENCES `lista` (`lista`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `listanormal_usuario_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `genero` (
  `genero` varchar(100) NOT NULL,
  PRIMARY KEY (`genero`)
);

CREATE TABLE `listaauto` (
  `lista` varchar(100) NOT NULL,
  `genero` varchar(100) NOT NULL,
  PRIMARY KEY (`lista`),
  KEY `listaauto_genero_FK` (`genero`),
  CONSTRAINT `listaauto_genero_FK` FOREIGN KEY (`genero`) REFERENCES `genero` (`genero`),
  CONSTRAINT `listaauto_listanormal_FK` FOREIGN KEY (`lista`) REFERENCES `listanormal` (`lista`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `biblioteca` (
  `lista` varchar(100) NOT NULL,
  PRIMARY KEY (`lista`),
  CONSTRAINT `biblioteca_lista_FK` FOREIGN KEY (`lista`) REFERENCES `lista` (`lista`)
);

CREATE TABLE `letra` (
  `texto` text NOT NULL,
  `letra` varchar(100) NOT NULL,
  PRIMARY KEY (`letra`)
);

CREATE TABLE `video` (
  `enlace` varchar(100) NOT NULL,
  `enlaceDescarga` varchar(100) DEFAULT NULL,
  `video` varchar(100) NOT NULL,
  PRIMARY KEY (`video`)
);

CREATE TABLE `cancion` (
  `cancion` varchar(100) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `autor` varchar(100) DEFAULT NULL,
  `duracion` int(10) unsigned DEFAULT NULL,
  `album` varchar(100) DEFAULT NULL,
  `genero` varchar(100) DEFAULT NULL,
  `video` varchar(100) DEFAULT NULL,
  `letra` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cancion`),
  KEY `cancion_letra_FK` (`letra`),
  KEY `cancion_video_FK` (`video`),
  KEY `cancion_genero_FK` (`genero`),
  CONSTRAINT `cancion_genero_FK` FOREIGN KEY (`genero`) REFERENCES `genero` (`genero`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `cancion_letra_FK` FOREIGN KEY (`letra`) REFERENCES `letra` (`letra`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `cancion_video_FK` FOREIGN KEY (`video`) REFERENCES `video` (`video`) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE `rlistacancion` (
  `lista` varchar(100) NOT NULL,
  `cancion` varchar(100) NOT NULL,
  PRIMARY KEY (`lista`,`cancion`),
  KEY `rlistacancion_cancion_FK` (`cancion`),
  CONSTRAINT `rlistacancion_cancion_FK` FOREIGN KEY (`cancion`) REFERENCES `cancion` (`cancion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rlistacancion_lista_FK` FOREIGN KEY (`lista`) REFERENCES `lista` (`lista`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `rusuariogenero` (
  `usuario` varchar(100) NOT NULL,
  `genero` varchar(100) NOT NULL,
  PRIMARY KEY (`usuario`,`genero`),
  KEY `rusuariogenero_genero_FK` (`genero`),
  CONSTRAINT `rusuariogenero_genero_FK` FOREIGN KEY (`genero`) REFERENCES `genero` (`genero`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rusuariogenero_usuario_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE
);

GRANT SELECT, INSERT, UPDATE, DELETE ON donia.* TO 'usr'@'localhost';
-- Por si acaso
GRANT ALL PRIVILEGES ON donia.* TO 'usr'@'%' WITH GRANT OPTION;

INSERT INTO donia.lista
(lista, nombre)
VALUES('l0', 'biblioteca');

INSERT INTO donia.biblioteca
(lista)
VALUES('l0');

INSERT INTO donia.usuario
(usuario, nombre, clave)
VALUES('u0', 'admin', 'u0');

INSERT INTO donia.usuarioadmin
(usuario)
VALUES('u0');

-- PARTE OPCIONAL: INSERCIÓN DE DATOS DE EJEMPLO

INSERT INTO donia.usuario (usuario,nombre,clave) VALUES
('pixies','pixies','pixies')
;

INSERT INTO donia.lista (lista,nombre) VALUES
('04ff8e47-2146-4a6d-a18c-8f5a52442e2b','Bob maestro')
,('32ff7af8-4e24-40d1-a3ba-5011c71449f7','Rock mainstream')
,('7900a334-5ceb-45e9-838a-c98ab3c309fd','Raperos')
,('a51d51b1-3659-43c8-a648-549c1c7aef3e','Indie español')
,('e49a3ab6-ebd6-4b08-a0b4-c7ee821dc77e','Punk')
,('fefcc882-ce6f-4676-ad31-950589d1264d','clasicos')
;

INSERT INTO donia.listanormal (lista,usuario) VALUES
('a51d51b1-3659-43c8-a648-549c1c7aef3e','pixies')
,('fefcc882-ce6f-4676-ad31-950589d1264d','pixies')
,('04ff8e47-2146-4a6d-a18c-8f5a52442e2b','u0')
,('32ff7af8-4e24-40d1-a3ba-5011c71449f7','u0')
,('7900a334-5ceb-45e9-838a-c98ab3c309fd','u0')
,('e49a3ab6-ebd6-4b08-a0b4-c7ee821dc77e','u0')
;

INSERT INTO donia.genero (genero) VALUES
('britrock')
,('indie')
,('punk')
,('rap')
,('reggae')
,('rock')
,('rock and roll')
;

INSERT INTO donia.listaauto (lista,genero) VALUES
('e49a3ab6-ebd6-4b08-a0b4-c7ee821dc77e','punk')
,('fefcc882-ce6f-4676-ad31-950589d1264d','rock and roll')
;

INSERT INTO donia.letra (texto,letra) VALUES
('Si estoy solo tu me acojes eres mi fiel compañía,
me hablas sincera y me esperas cuando empieza el día.
Mi guía, mi faro de Alejandría, si me ves perdido
te miro y elimino la tristeza en un suspiro.

Das sentido a mi existencia, tú desobediencia,
tú, sola presencia merece mi reverencia,
tú me diste un don, fuiste mi espada,
siempre encerrada en tu prisión si la inspiración faltaba.

Desde la nada me abrazas, no prohibes ni amenazas
tan romántica y auténtica, tú nunca te disfrazas
como un hada y un verdugo firme escudo en la batalla,
tú, a quién acudo si otros fallan.

Me das retos, aventuras y responsabilidad,
me das éxito y dinero me quitas la intimidad,
me exiges crear, me haces temblar, soñar, me curas
me eliges para hablar si las calles están mudas.
Me desnudas con ternura y siento tu tacto y tu olor,
si te veo volar libre entre la voz de un cantautor
eres Ópera y Flamenco, eres todo lo que tengo y te amo,
mientras brotas entre las notas de un piano.

Y me desintegras pintando estas noches negras,
me alegras, me invades, me evades, alejas las tinieblas
y me resucitas siempre, nunca me mientes
eres el recipiente donde lágrimas se vierten.

Eres Tango y eres ritmo vives en do, re, mi, fa
impredecible compás cuando te vistes de Jazz,
llegas y me das ógixeno, mi único somnífero
si el mortífero estrés tensa mis músculos, discípulo

de tu inmensa maestría cuando no te conocía,
como podía vivir sin percibir tu melodía
fuiste mía y solo mía en mis horas de miseria,
compones la banda sonora de esta tragicomedia.
Tú reina entre mil reyes, cumbre de mis valles,
me levitas y asi evitas que tanto odio me ametralle
tú, si eres Hip-Hop muestras denuncia y carisma,
pero te vistes de clásica y sigues siendo la misma.

Eres tú, mi suerte, eres tú, tan fuerte, eres tú, tú, tan diferente
surges y de repente la vida olvida a la muerte.
Imposible de tenerte si naces de un pentagrama,
si el drama yace en mi cama me abres enormes ventanas,

tu llama jamás se apaga, luz de eterna juventud
cuando llores punteando una guitarra de Blues.
Eres tú, la rabia sucia y rasgada de Kurt Cobain
el compromiso sincero de Marvin Gaye,

la grandeza de John Coltrane improvisando con el saxo,
la mirada niñada en los ojos de Michael Jackson.
Y es que tu son me sedujo, tu luz me dejo perplejo y caí,
reviví como el sol en forma de Soul y R&B

bebí de tí el elixir y resistí los golpes,
si fui torpe encontre por fin mi norte, mi soporte.
Entre acordes de Mark Knopfler redobles de Hanckock Herbi,
de Vivaldi hasta Elvis, desde Verdi hasta Jack Berry.

Inmortales piezas musicales hacen que el tiempo se pare,
estallan como bombas provocando ondas letales
de esperanza, de aliento y vida, mi gran amiga
solo tu haces eficaces todas las frases que diga,

mi balanza, mi paz, mi druida, en la fatiga
solo tu haces realidad los sueños que yo persiga.
Y es que sin ti no hay destino, solo piedra y mil caminos,
sin ti, soy un mimo temblando en el camerino.

Pero tu acojes mis voces si me ves desorientado,
y bailas conmigo un Vals igual que dos enamorados.
Eres la llave inmortal que abre este mental presidio,
desde Tiste-tutanclan hasta el ójala de Silvio.

Envidio el poder que impones en canciones
despiertas mis emociones, con creaciones de Ennio Morricone.
Sensaciones sin control cuando eres Rock n Roll,
el erotismo de un bemol en la voz de Diana Krall

el solo de guitarra eléctrica que el silencio rompe,
la armónica que esconden las manos de Steve Wonder.
Te vi dónde todo acaba y Nada Sira con Black Sabbath
respiras vida con la calma que inspira Bob Dylan,

oscilas y posees a James Brown mueves su cuerpo,
junto a Freddy Mercury, Ray Charles jamás habrán muerto.
Y es cierto da igual que suenes con un arpa o un acai,
con la clase de Frank Sinatra o de Barry white.

Eres la métrica enigmática que envuelve mi ser y lo salva,
el idioma con el que los dioses hablan, eres música.','0b65a6c3-d4a6-4c8a-ba76-c0632da72bd5')
,('He dado tanto por ti Tanto por mi Lo deje todo cuando te conoci Suena y se escucha Me deje mucha de la energía que tengo en escribir Y solo gracias a ti me siento feliz A quedarme con lo positivo aprendi Y el momento en que todo falla, el bote se te encalla Puedo volver a subir Un movimiento que se extiende Quien lo sabe lo siente One love, one blood… en cada continente Una vibra positiva con letra consciente Y una forma de mirar la vida diferente Se que no soy un delincuente Por fumar la marihuana no soy un demente No he parado de trabajar preguntale a mi gente Mama se murió, yo solo era un adolescente Me crie en el bien , creo en la lucha Es el reggae music lo que solo mi alma escucha Tiro millas por que carretera queda mucha Demasiada gente alza la voz y nadie escucha Y gracias a ti, de ti aprendi a mirarme tal como soy Marca el camino si no se a donde voy Sweet reggae music He dado tanto por ti Tanto por mi Lo deje todo cuando te conoci Suena y se escucha Me deje mucha de la energía que tengo en escribir Y solo gracias a ti me siento feliz A quedarme con lo positivo aprendi Y el momento en que todo falla, el bote se te encalla Puedo volver a subir Debo agradecerte tanto Recorro el mundo viajando Tanta prisa y no es casualidad que me ves siempre cantando una melodía calida. Contigo vivo la vida en otra realidad Siente como se contagia esa tranquilidad y solo voy donde quieran escuchar Hoy sigo luchando para saber quien soy Todo lo que pueda enseñar te lo doy Y siempre que me necesites estoy Te debo tanto es gracias a ti de ti aprendi a mirarme tal como soy Marca el camino si no se a donde voy Sweet reggae music He dado tanto por ti Tanto por mi Lo deje todo cuando te conoci Suena y se escucha Me deje mucha de la energía que tengo en escribir Y solo gracias a ti me siento feliz A quedarme con lo positivo aprendi Y el momento en que todo falla, el bote se te encalla Puedo volver a subir','16f105f7-b4b5-41a4-8848-3195cb05dc3d')
,('When I look into your eyes
I can see a love restrained
But darlin when I hold you
Dont you know I feel the same

Cause nothin lasts forever
And we both know hearts can change
And its hard to hold a candle
In the cold November rain

Weve been through this such a long long time
Just tryin to kill the pain

But lovers always come and lovers always go
And no ones really sure whos lettin go today
Walking away

If we could take the time
To lay it on the line
I could rest my head
Just knowin that you were mine
All mine
So if you want to love me
Then darlin dont refrain
Or Ill just end up walkin
In the cold November rain

Do you need some time...on your own
Do you need some time...all alone
Everybody needs some time... on their own
Dont you know you need some time...all alone

I know its hard to keep an open heart
When even friends seem out to harm you
But if you could heal a broken heart
Wouldnt time be out to charm you

Sometimes I need some time...on my own
Sometimes I need some time...all alone
Everybody needs some time... on their own
Dont you know you need some time...all alone

And when your fears subside
And shadows still remain
I know that you can love me
When theres no one left to blame
So never mind the darkness
We still can find a way
Cause nothin lasts forever
Even cold November rain

Dont ya think that you need somebody
Dont ya think that you need someone
Everybody needs somebody
Youre not the only one
Youre not the only one','18679bb2-eb61-4b7a-a29c-a65e68cf2c33')
,('Well the kids are all hopped up and ready to go
Theyre ready to go now they got their surfboards
And theyre going to the discotheque Au Go Go
But she just couldnt stay she had to break away
Well New York City really has is all oh yeah, oh yeah

Sheena is a punk rocker
Sheena is a punk rocker
Sheena is a punk rocker now

Sheena is a punk rocker
Sheena is a punk rocker
Sheena is a punk rocker now

Well shes a punk punk, a punk rocker
Punk punk a punk rocker
Punk punk a punk rocker
Punk punk a punk rocker

Well the kids are all hopped up and ready to go
Theyre ready to go now they got their surfboards
And theyre going to the discotheque Au Go Go
But she just couldnt stay she had to break away
Well New York City really has is all oh yeah, oh yeah

Sheena is a punk rocker
Sheena is a punk rocker
Sheena is a punk rocker now

Sheena is a punk rocker
Sheena is a punk rocker
Sheena is a punk rocker now

Well shes a punk punk, a punk rocker
Punk punk a punk rocker
Punk punk a punk rocker
Punk punk a punk rocker

Sheena is a punk rocker
Sheena is a punk rocker
Sheena is a punk rocker now

Sheena is a punk rocker
Sheena is a punk rocker
Sheena is a punk rocker now

Sheena is a punk rocker
Sheena is a punk rocker
Sheena is a punk rocker now','25907e14-78fd-4598-8792-6f5ba21e95aa')
,('All of my love
All of my kissing
You dont know what youve been amissing
Oh boy, when youre with me
Oh boy, the world can see
That you, were meant, for me

All of my life
Ive been awaiting
Tonight therell be no... hesitating
Oh boy, when youre with me
Oh boy, the world can see
That you, were meant, for me
Stars appear and shadows are falling
You can hear my heart acalling
A little bit aloving makes everything right
Im going to see my baby tonight

Dum-dee-dum-dum
Oh boy
Dum-dee-dum-dum
Oh boy
Ooh-ooh-ooh-oooooh','3fcf5f6b-3969-45ea-8401-0c79f1c9d0bc')
,('Vicios y placeres que nos subyugan
E- e, cual es el tuyo?
Quiza escribes, bebes, fumas? O un poco de todo?
Olvida el mundo y ven de viaje hacia apologia del hedonismo
Y deja que te atrape

KASE O

Explicales como les embriagas en rios de tinta

LIRIKO

Escribo rimas frases estrofas parrafos, gasto boligrafos
Escribo dedicatorias y autografos
Escribo mi nombre en un mármol
Escribo en mi cuarto en el bus o a la sombra de un arbol
Cualquier trozo de papel mi pentagrama
Son canciones con sabor a drama
Rabia, amor, placer dolor lo que transmita el alma
Yo solo pido un ritmo
Tu dame tiempo, espacio y calma y diga donde firmo
Firmo contratos, cheques, facturas y multas
Siempre el puto poli vacilon que no acepta disculpas
Pienso luego existo, escribo luego estoy vivo
Digo a todo cristo que prefiero un disco mejor que un libro
Escribo ciego feliz triste o sereno
Esquivo obstáculos sin tocar freno
Un fugitivo del ritmo micro fenómeno y un objetivo
Rap del bueno
Sabes que sueno tan, gordo tocho basto solemne mistico
Mi flow caracteristico inspirado en el patinaje artistico
Yo siempre tengo un plan, pase lo que pase
Incorregible en cada frase, por eso me duermo en tu clase
No somos musicos, solo a cada rima le saco multiplos
Y en esto somos los unicos
Cuando un rap sedujo mas que tu lenceria
Deje mi firma sobre el polvo de tu estanteria
Yo rapeo predico informo presagio
Es un remedio y no una enfermedad lo que contagio
Y es que el mejor testigo es el micrófono
Cuando escribo, cuando bebo cuando fumo, como no','46ed3756-5afc-4fd5-82ec-b549f5642fda')
,('Quiero ser alemán
quiero ser liberal
quiero dar y recibir
quiero ser occidental
quiero ser Norma Jean
quiero ser el Watergate
quiero ser la vía alternativa
porque de esta estoy seguro que os cansaréis
quiero hablar con propiedad
que me acojan los Bardem
quiero ser el tipo de persona que convierte tu dinero
en la ley
quiero ser la MTV
quiero ser el Opus Dei
quiero que esto sea un hit
quiero que esto sea un hit
quiero ser sádico
y que grites sin parar
quiero ser el tipo de persona que te abraza
aunque me caigas mal
quiero ser tu sucesor
quiero una tarjeta black
quiero convencerte de que
lo que está sonando es un hit
es un hit
quiero ser fanático
quiero un cargo público
quiero ser clásico
quiero hablar sucio
quiero ser moderador
de un debate semanal
quiero convencerte de que lo que esta pasando es normal
quiero ser español
quiero ser Lady Di
quiero convencerte de que
lo que está sonando es un hit
es un hit','4e2535b2-7313-4958-a5d3-3b8368d3d9a1')
,('','51ac966b-5014-47ea-a7f7-e48946db4e55')
,('Theres a lady whos sure all that glitters is gold
And shes buying a stairway to heaven.
When she gets there she knows, if the stores are all closed
With a word she can get what she came for.
Ooh, ooh, and shes buying a stairway to heaven.

Theres a sign on the wall but she wants to be sure
Cause you know sometimes words have two meanings.
In a tree by the brook, theres a songbird who sings,
Sometimes all of our thoughts are misgiven.

Ooh, it makes me wonder,
Ooh, it makes me wonder.

Theres a feeling I get when I look to the west,
And my spirit is crying for leaving.
In my thoughts I have seen rings of smoke through the trees,
And the voices of those who stand looking.

Ooh, it makes me wonder,
Ooh, it really makes me wonder.

And its whispered that soon, if we all call the tune,
Then the piper will lead us to reason.
And a new day will dawn for those who stand long,
And the forests will echo with laughter.

If theres a bustle in your hedgerow, dont be alarmed now,
Its just a spring clean for the May queen.
Yes, there are two paths you can go by, but in the long run
Theres still time to change the road youre on.
And it makes me wonder.

Your head is humming and it wont go, in case you dont know,
The pipers calling you to join him,
Dear lady, can you hear the wind blow, and did you know
Your stairway lies on the whispering wind?

And as we wind on down the road
Our shadows taller than our soul.
There walks a lady we all know
Who shines white light and wants to show
How everything still turns to gold.
And if you listen very hard
The tune will come to you at last.
When all are one and one is all
To be a rock and not to roll.

And shes buying a stairway to heaven. ','7fac0b19-ea72-4d4c-8b9e-402e9f5c6dde')
,('Spanish songs in Andalucía
The shooting sites in the days of 39
Oh, please, leave the ventana open
Federico Lorca is dead and gone
Bullet holes in the cemetery walls
The black cars of Guardia civil
Spanish bombs on the Costa Rica
Im flying in on a DC-10 tonight
Spanish bombs, yo te quiero infinito
Yo te quiero, oh mi corazón
Spanish bombs, yo te quiero infinito
Yo te quiero, oh mi corazón
Spanish weeks in my disco casino
The freedom fighters died upon the hill
They sang the red flag
They wore the black one
But after they died it was mockingbird hill
Back home the buses went up in flashes
The Irish tomb was drenched in blood
Spanish bombs shatter the hotels
My señoritas rose was nipped in the bud
Spanish bombs, yo te quiero infinito
Yo te quiero, oh mi corazón
Spanish bombs, yo te quiero infinito
Yo te quiero, oh mi corazón
The hillsides ring with free the people
Or can I hear the echo from the days of 39?
With trenches full of poets
The ragged army, fixin bayonets to fight the other line
Spanish bombs rock the province
Im hearing music from another time
Spanish bombs on the Costa Brava
Im flying in on a DC 10 tonight
Spanish bombs, yo te quiero infinito
Yo te quiero, oh mi corazón
Spanish bombs, yo te quiero infinito
Yo te quiero, oh mi corazón
Oh mi corazón...
Oh mi corazón...
Spanish songs in Andalucía, mandolina, oh mi corazón
Spanish songs in Granada, oh mi corazón
Oh mi corazón...
Oh mi corazón...
Oh mi corazón...
Oh mi corazón...','a05d7c7c-9974-4f1f-9e03-d8d25918ac04')
;
INSERT INTO donia.letra (texto,letra) VALUES
('I wanna love you and treat you right,
I wanna love you every day and every night:
Well be together with a roof right over our heads,
Well share the shelter of my single bed,
Well share the same room, yeah! - for Jah provide the bread.
Is this love - is this love - is this love -
Is this love that Im feelin?
Is this love - is this love - is this love -
Is this love that Im feelin?
I wanna know - wanna know - wanna know now!
I got to know - got to know - got to know now!

I-I-I-I-I-I-I-I-I - Im willing and able,
So I throw my cards on your table!
I wanna love you - I wanna love and treat - love and treat you right,
I wanna love you every day and every night:
Well be together, yeah! - with a roof right over our heads,
Well share the shelter, yeah, oh now! - of my single bed,
Well share the same room, yeah! - for Jah provide the bread.

Is this love - is this love - is this love -
Is this love that Im feelin?
Is this love - is this love - is this love -
Is this love that Im feelin?
Wo-o-o-oah! Oh yes, I know, yes, I know - yes, I know now!
Yes, I know, yes, I know - yes, I know now!

I-I-I-I-I-I-I-I-I - Im willing and able,
So I throw my cards on your table!
See: I wanna love ya, I wanna love and treat ya -
Love and treat ya right.
I wanna love you every day and every night:
Well be together, with a roof right over our heads!
Well share the shelter of my single bed,
Well share the same room, yeah! Jah provide the bread.
Well share the shelter of my single bed','b7b51dc6-f091-4b19-861d-050f79fdbd22')
,('Inténtalo
apaga este motor en movimiento
Mi fabrica de baile
no cabe en tu corazón pequeño.

Inténtalo
apaga este motor en movimiento
Mi fabrica de baile
no cabe en tu corazón pequeño.

El médico me dijo
que quitara el café de mi vida
solo tomo tres tazas de café al día
y el está muerto y yo viva.

Inténtalo
apaga este motor en movimiento
Mi fabrica de baile
no cabe en tu corazón pequeño.

Inténtalo
apaga este motor en movimiento
Mi fabrica de baile
no cabe en tu corazón pequeño.','b956e06e-07d5-4a8e-89c5-4244922c6cee')
,('He dado tanto por ti Tanto por mi Lo deje todo cuando te conoci Suena y se escucha Me deje mucha de la energía que tengo en escribir Y solo gracias a ti me siento feliz A quedarme con lo positivo aprendi Y el momento en que todo falla, el bote se te encalla Puedo volver a subir Un movimiento que se extiende Quien lo sabe lo siente One love, one blood… en cada continente Una vibra positiva con letra consciente Y una forma de mirar la vida diferente Se que no soy un delincuente Por fumar la marihuana no soy un demente No he parado de trabajar preguntale a mi gente Mama se murió, yo solo era un adolescente Me crie en el bien , creo en la lucha Es el reggae music lo que solo mi alma escucha Tiro millas por que carretera queda mucha Demasiada gente alza la voz y nadie escucha Y gracias a ti, de ti aprendi a mirarme tal como soy Marca el camino si no se a donde voy Sweet reggae music He dado tanto por ti Tanto por mi Lo deje todo cuando te conoci Suena y se escucha Me deje mucha de la energía que tengo en escribir Y solo gracias a ti me siento feliz A quedarme con lo positivo aprendi Y el momento en que todo falla, el bote se te encalla Puedo volver a subir Debo agradecerte tanto Recorro el mundo viajando Tanta prisa y no es casualidad que me ves siempre cantando una melodía calida. Contigo vivo la vida en otra realidad Siente como se contagia esa tranquilidad y solo voy donde quieran escuchar Hoy sigo luchando para saber quien soy Todo lo que pueda enseñar te lo doy Y siempre que me necesites estoy Te debo tanto es gracias a ti de ti aprendi a mirarme tal como soy Marca el camino si no se a donde voy Sweet reggae music He dado tanto por ti Tanto por mi Lo deje todo cuando te conoci Suena y se escucha Me deje mucha de la energía que tengo en escribir Y solo gracias a ti me siento feliz A quedarme con lo positivo aprendi Y el momento en que todo falla, el bote se te encalla Puedo volver a subir','d6a6cf31-0b1b-43d8-9ed4-350a681cfa17')
;

INSERT INTO donia.video (enlace,enlaceDescarga,video) VALUES
('http://toogl.es/#/view/zGgfHZ02I2k','','0b785f2c-40ce-46c2-84c3-918c64546208')
,('https://www.youtube.com/watch?v=Q9Q1Zyeyy_Y','https://sv48.onlinevideoconverter.com/download?file=c2a0f5i8g6f5a0e4','15aa1177-4385-4f60-8d3d-76028aa84817')
,('http://toogl.es/#/view/Ef3UFqO-wKg','http://toogl.es/#/view/Ef3UFqO-wKg','2d38ab46-d29b-44fa-a6fd-46211c5a1ffa')
,('http://toogl.es/#/view/ertt3o1x65c','','49ba8ac6-6dc1-4dc3-a768-486d3733c261')
,('https://www.youtube.com/watch?v=DfYRIN3U3SU','https://sv7.onlinevideoconverter.com/download?file=h7d3i8h7g6b1f5e4','4ae654c1-6094-460e-8c1d-db5bff0f2ac5')
,('http://toogl.es/#/view/M3zQX7A-qQU','','6104fe83-3542-4e1e-bc9b-4f3fc39f35b0')
,('https://www.youtube.com/watch?v=CeqLQXCp5BU','https://sv47.onlinevideoconverter.com/download?file=i8f5e4f5a0a0b1e4','8130c861-1e8c-4f51-917d-6e33160e5c61')
,('https://www.youtube.com/watch?v=OPqS0Y5-2L4','https://sv71.onlinevideoconverter.com/download?file=h7d3b1h7j9g6a0e4','a26bde18-70b4-44e5-b18d-dabad56e4746')
,('https://www.youtube.com/watch?v=Q9Q1Zyeyy_Y','https://sv48.onlinevideoconverter.com/download?file=c2a0f5i8g6f5a0e4','ac2a389b-4ad8-4b6c-9a4f-5e8d1d19ba46')
,('http://toogl.es/#/view/j53OPR-cuYY','','ac97c929-4eac-4970-b078-56abad601141')
;
INSERT INTO donia.video (enlace,enlaceDescarga,video) VALUES
('https://www.youtube.com/watch?v=CHekNnySAfM','https://sv52.onlinevideoconverter.com/download?file=h7d3j9e4c2i8d3e4','ae54281b-6cdd-4cb0-b031-002c03584823')
,('http://toogl.es/#/view/ZZCt92zLmLI','','b41c749c-cbed-4b6a-b9e6-c104bd91fb3b')
,('https://www.youtube.com/watch?v=TrgsYhHGQ0s','https://s37.onlinevideoconverter.com/download?file=d3f5i8c2a0b1j9c2','b9b89c1e-d935-4f57-a620-d082a9435df4')
;

INSERT INTO donia.cancion (cancion,titulo,autor,duracion,album,genero,video,letra) VALUES
('00c4b9b0-3806-493f-8246-e88ad752b1ce','Mi fabrica de baile','Joe Crepusculo',320,'Baile de magos','indie','2d38ab46-d29b-44fa-a6fd-46211c5a1ffa','b956e06e-07d5-4a8e-89c5-4244922c6cee')
,('0c3f9543-200a-4f87-a0dc-51d19bedd514','El Idioma De Los Dioses','Nach',400,'No se','rap','a26bde18-70b4-44e5-b18d-dabad56e4746','0b65a6c3-d4a6-4c8a-ba76-c0632da72bd5')
,('5a80318b-d592-48f5-97be-5bf7536914b5','Stairway to heaven','Led Zeppelin',480,'IV','rock','8130c861-1e8c-4f51-917d-6e33160e5c61','7fac0b19-ea72-4d4c-8b9e-402e9f5c6dde')
,('5f340504-3af9-4a97-86c0-0ffa53de3aa2','Haciendo Lo Nuestro','Violadores del verso',380,'No se','rap','b9b89c1e-d935-4f57-a620-d082a9435df4','46ed3756-5afc-4fd5-82ec-b549f5642fda')
,('7171347d-c872-4c9f-8160-708b8902f424','Oh boy','Buddy Holly',320,'Buddy Holly','rock and roll','ac97c929-4eac-4970-b078-56abad601141','3fcf5f6b-3969-45ea-8401-0c79f1c9d0bc')
,('921c691a-773c-42ce-a873-a4f815856f05','November Rain','Guns N Roses',375,'No se','rock','4ae654c1-6094-460e-8c1d-db5bff0f2ac5','18679bb2-eb61-4b7a-a29c-a65e68cf2c33')
,('b5d24837-55d9-43ba-8f98-f4c22d2fd843','Is This Love','Bob Marley',329,'No se','reggae','ae54281b-6cdd-4cb0-b031-002c03584823','b7b51dc6-f091-4b19-861d-050f79fdbd22')
,('c578e773-0012-481f-a6d4-bb959dc44cca','Tipo D','Leon Benavente',345,'Leon Benavente 2','indie','6104fe83-3542-4e1e-bc9b-4f3fc39f35b0','4e2535b2-7313-4958-a5d3-3b8368d3d9a1')
,('d7cb8176-bfb2-48da-8890-30fc406babce','Sheena Is A Punk Rocker ','Ramones',180,'Rocket to russia','punk','0b785f2c-40ce-46c2-84c3-918c64546208','25907e14-78fd-4598-8792-6f5ba21e95aa')
,('e1c63d22-c6eb-4d9c-baae-9b40cbc63afa','Intermission','Blur',300,'Modern Life Is Rubbish','britrock','b41c749c-cbed-4b6a-b9e6-c104bd91fb3b','51ac966b-5014-47ea-a7f7-e48946db4e55')
;
INSERT INTO donia.cancion (cancion,titulo,autor,duracion,album,genero,video,letra) VALUES
('f958b3ef-08de-4840-bf42-b1cbc76b6ab7','Spanish Bombs','The Clash',320,'London Calling','punk','49ba8ac6-6dc1-4dc3-a768-486d3733c261','a05d7c7c-9974-4f1f-9e03-d8d25918ac04')
;

INSERT INTO donia.rlistacancion (lista,cancion) VALUES
('04ff8e47-2146-4a6d-a18c-8f5a52442e2b','b5d24837-55d9-43ba-8f98-f4c22d2fd843')
,('32ff7af8-4e24-40d1-a3ba-5011c71449f7','5a80318b-d592-48f5-97be-5bf7536914b5')
,('32ff7af8-4e24-40d1-a3ba-5011c71449f7','921c691a-773c-42ce-a873-a4f815856f05')
,('7900a334-5ceb-45e9-838a-c98ab3c309fd','0c3f9543-200a-4f87-a0dc-51d19bedd514')
,('7900a334-5ceb-45e9-838a-c98ab3c309fd','5f340504-3af9-4a97-86c0-0ffa53de3aa2')
,('a51d51b1-3659-43c8-a648-549c1c7aef3e','00c4b9b0-3806-493f-8246-e88ad752b1ce')
,('a51d51b1-3659-43c8-a648-549c1c7aef3e','c578e773-0012-481f-a6d4-bb959dc44cca')
,('e49a3ab6-ebd6-4b08-a0b4-c7ee821dc77e','d7cb8176-bfb2-48da-8890-30fc406babce')
,('fefcc882-ce6f-4676-ad31-950589d1264d','7171347d-c872-4c9f-8160-708b8902f424')
,('l0','00c4b9b0-3806-493f-8246-e88ad752b1ce')
;
INSERT INTO donia.rlistacancion (lista,cancion) VALUES
('l0','0c3f9543-200a-4f87-a0dc-51d19bedd514')
,('l0','5a80318b-d592-48f5-97be-5bf7536914b5')
,('l0','5f340504-3af9-4a97-86c0-0ffa53de3aa2')
,('l0','7171347d-c872-4c9f-8160-708b8902f424')
,('l0','921c691a-773c-42ce-a873-a4f815856f05')
,('l0','b5d24837-55d9-43ba-8f98-f4c22d2fd843')
,('l0','c578e773-0012-481f-a6d4-bb959dc44cca')
,('l0','d7cb8176-bfb2-48da-8890-30fc406babce')
,('l0','e1c63d22-c6eb-4d9c-baae-9b40cbc63afa')
,('l0','f958b3ef-08de-4840-bf42-b1cbc76b6ab7')
;

INSERT INTO donia.rusuariogenero (usuario,genero) VALUES
('pixies','indie')
,('u0','punk')
,('u0','reggae')
;
