create database films;
create sequence film_id;
create table film (
id int not null default nextval('film_id') primary key,
"name" varchar,
date_film date,
description text,
genre varchar
);

create sequence user_id;
create table users (
id int not null default  nextval ('user_id') primary key,
last_name varchar,
first_name varchar,
email varchar,
phone int
);
create sequence subscriptions_id;
create table subscriptions (
id int not null default  nextval ('subscriptions_id') primary key,
user_id int references users(id)
);

create sequence news_id;
create table news (
id int not null default  nextval ('news_id') primary key,
user_id int references users(id),
title varchar,
news text,
date_news date
);
create sequence coment_id;
create table coment (
id int not null default  nextval ('coment_id') primary key,
user_id int references users(id),
coment text,
date_coment date,
film_id int references film(id),
news_id int references news(id)
);

insert into film ("name", date_film, description, genre) values
('Холоп','02-07-2019','Гриша (Милош Бикович) — сын олигарха Павла (Александр Самойленко), избалованный и наглый мажор,
проводящий практически всё время в ночных клубах, потребительски относящийся к женщинам и привыкший к полной безнаказанности.','комедия'),
('Гудбай, Америка','02-07-2019','Виктор Сергеевич едет в Америку в гости к дочери и с ужасом обнаруживает, что его внук Пол хоть и говорит по-русски, но не понимает простых вещей', 'комедия/драма'),
('Плохие парни навсегда','05-11-2020','Бёрнетт рассорился с напарником, оставил службу в полиции Майами и занялся частной сыскной деятельностью.','боевик'),
('Джуманджи: Зов джунглей','07-08-2017','Четверо подростков оказываются внутри игры «Джуманджи». Их ждет схватка с носорогами, черными мамбами','приключения/комедия'),
('Последний богатырь','21-07-2017','Иван, обычный парень, по воле случая переносится из современной Москвы в фантастическую страну Белогорье.','фэнтези/комедия');

alter table film drop column genre;
create sequence genere_id;
create table genre
(
id int not null default nextval('genere_id') primary key,
neme varchar
);
alter table film add column genre int default null references genre(id);

 insert into genre (neme) values
 ('комедия'),
 ('комедия/драма'),
 ('боевик'),
 ('приключения/комедия'),
 ('фэнтези/комедия');

 update film set genre=(select id from genre where neme ='комедия' limit 1 ) where name = 'Холоп';
 update film set genre=(select id from genre where neme ='комедия/драма' limit 1 ) where name = 'Гудбай, Америка';
 update film set genre=(select id from genre where neme ='боевик' limit 1 ) where name = 'Плохие парни навсегда';
 update film set genre=(select id from genre where neme ='приключения/комедия' limit 1 ) where name = 'Джуманджи: Зов джунглей';
 update film set genre=(select id from genre where neme ='фэнтези/комедия' limit 1 ) where name = 'Последний богатырь';

insert into users (last_name, first_name, email, phone) values
('Сережа','Бубликов','byblikov@gmail.com', 9765435),
('Катя','Машина','mashina@gmail.com', 97897665),
('Ольга','Зубкова','zybkova@gmail.com', 919543215),
('Анатолий','Брусников','brusnikov@gmail.com', 97653337),
('Александра','Шурочкина','Shurochkina@gmail.com', 9822222);

 insert into subscriptions (user_id) values
((select id from users where id=1 limit 1)),
((select id from users where id=2 limit 1)),
((select id from users where id=3 limit 1)),
((select id from users where id=4 limit 1)),
((select id from users where id=5 limit 1));

insert into news (user_id, title, news, date_news) values
((select id from users where id=1 limit 1),'Все про фильмы','Желаете смотреть фильмы 2022 онлайн? Тогда вы по адресу! У нас собраны лучшие новинки кино 2022 в хорошем качестве.','20-09-2020'),
((select id from users where id=2 limit 1),'О комедиях','Кинокоме?дия или комедийный фильм — комедия на киноэкране.','20-09-2020'),
((select id from users where id=3 limit 1),'Новинки','Подборки лучших фильмов в Full HD. Тысячи фильмов и сериалы от ведущих мировых студий.','20-09-2020'),
((select id from users where id=4 limit 1),'Фильмы для любителей фантастики','Топ 100 лучших фантастических фильмов · 1. Терминатор 2: Судный день тюд','20-09-2020'),
((select id from users where id=5 limit 1),'Популярные фильмы','Популярные фильмы и сериалы. Рейтинг составлен на основе посещаемости страниц фильмов,
 а также запросов к поисковой системе сайта.','20-09-2020');


insert into coment (user_id, coment, date_coment, film_id, news_id) values
((select id from users where id=1 limit 1),'like film', '22-03-2020',(select id from film where id=1 limit 1), NULL ),
((select id from users where id=2 limit 1),'Interesting movies', '22-03-2020',(select id from film where id=2 limit 1), NULL ),
((select id from users where id=3 limit 1),'Good film', '22-03-2020',(select id from film where id=3 limit 1), NULL ),
((select id from users where id=4 limit 1),'good movie', '22-03-2020',(select id from film where id=4 limit 1), NULL ),
((select id from users where id=5 limit 1),'funny movies', '22-03-2020',(select id from film where id=5 limit 1), NULL ),
((select id from users where id=1 limit 1),'like film', '22-03-2020', null, (select id from news where id=1 limit 1)),
((select id from users where id=2 limit 1),'Good film', '22-03-2020', null, (select id from news where id=2 limit 1)),
((select id from users where id=3 limit 1),'funny movies', '22-03-2020', null, (select id from news where id=3 limit 1)),
((select id from users where id=4 limit 1),'Good film', '22-03-2020', null, (select id from news where id=4 limit 1)),
((select id from users where id=5 limit 1),'like film', '22-03-2020', null,  (select id from news where id=5 limit 1));



select film.*, coment.* from film
left join coment on film.id = coment.film_id;