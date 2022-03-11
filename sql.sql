CREATE
DATABASE taco_cloud;

USE
taco_cloud;
CREATE TABLE IF NOT EXISTS `Ingredient`
(
    `id` VARCHAR
(
    100
) NOT NULL,
    `name` VARCHAR
(
    100
) NOT NULL,
    `type` VARCHAR
(
    40
) NOT NULL,
    PRIMARY KEY
(
    `id`
)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into Ingredient (id, name, type)
values ("FLTO", "Flour Tortilla", "WRAP"),
       ("COTO", "Corn Tortilla", "WRAP");
insert into Ingredient (id, name, type)
values ("GRBF", "Ground Beef", "PROTEIN"),
       ("CARN", "Carnitas", "PROTEIN");
insert into Ingredient (id, name, type)
values ("TMTO", "Diced Tomatoes", "VEGGIES");
insert into Ingredient (id, name, type)
values ("LETC", "Lettuce", "VEGGIES");
insert into Ingredient (id, name, type)
values ("CHED", "Cheddar", "CHEESE");
insert into Ingredient (id, name, type)
values ("JACK", "Monterrey Jack", "CHEESE");
insert into Ingredient (id, name, type)
values ("SLSA", "Salsa", "SAUCE"),
       ("SRCR", "Sour Cream", "SAUCE");

create table if not exists Taco
(
    `id`
    bigint,
    `name`
    varchar
(
    50
) not null,
    `createdAt` timestamp not null
    );

create table if not exists Taco_Ingredients
(
    taco
    bigint
    not
    null,
    ingredient
    varchar
(
    4
) not null
    );

create table if not exists Taco_Order
(
    `id`
    bigint
    primary
    key,
    `deliveryName`
    varchar
(
    50
) not null,
    `deliveryStreet` varchar
(
    50
) not null,
    `deliveryCity` varchar
(
    50
) not null,
    `deliveryState` varchar
(
    2
) not null,
    `deliveryZip` varchar
(
    10
) not null,
    `ccNumber` varchar
(
    16
) not null,
    `ccExpiration` varchar
(
    5
) not null,
    `ccCVV` varchar
(
    3
) not null,
    `placedAt` timestamp not null
    );

create table if not exists Taco_Order_Tacos
(
    tacoOrder
    bigint
    not
    null,
    taco
    bigint
    not
    null
);

create table if not exists Taco
(
    `id`
    bigint,
    `username`
    varchar
(
    50
), `password` varchar
(
    50
), `fullname` varchar
(
    50
), `street` varchar
(
    50
), `city` varchar
(
    50
), `state` varchar
(
    50
)), `zip` varchar
(
    50
), `phoneNumber` varchar
(
    50
))