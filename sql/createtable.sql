--Luodaan kyselyn vastaustaulukko

CREATE TABLE vastauksetwow(
    id integer --rowid autoincrement
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