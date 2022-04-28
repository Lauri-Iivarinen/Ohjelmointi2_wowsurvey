CREATE TABLE vastaukset(
    id integer --rowid autoincrement
    ,nickname varchar(20)
    ,hoursplayed integer
    ,gamesperweek integer
    ,favoriteofyear varchar(30)
    ,favoriteofalltime varchar(30)
    ,pineappleonpizza boolean
    ,PRIMARY KEY(id)
);

--TESTI INSERT KYSELYLLE
INSERT INTO vastaukset(nickname,hoursplayed,gamesperweek,favoriteofyear,favoriteofalltime,pineappleonpizza)
VALUES(
    'Tuul'
    ,50
    ,1
    ,'wow'
    ,'tlou1'
    ,true
);

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

--TESTI INSERT WOW KYSELYLLE
INSERT INTO vastauksetwow(nickname,hoursplayed,progressdiff,progressnum,favboss,mplus,playpvp,removeclass,whyremove,expachype)
VALUES(
    'tuul'
    ,35
    ,'mythic'
    ,6
    ,'artificer'
    ,3007
    ,false
    ,'hunter'
    ,'too many in game'
    ,true
);