--Luodaan kyselyn vastaustaulukko

--POSTGRESQL SYNTAKSI
CREATE TABLE vastauksetwow(
    id SERIAL
    ,nickname varchar(20)
    ,hoursplayed integer
    ,progressdiff varchar(10)
    ,progressnum integer
    ,favboss varchar(20)
    ,mplus integer
    ,playpvp boolean
    ,removeclass varchar(10)
    ,whyremove varchar(150)
    ,expachype boolean
    ,PRIMARY KEY(id)
);