<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Form page</title>
    <link href="https://fonts.googleapis.com/css2?family=Prompt:wght@200&family=Staatliches&display=swap"
        rel="stylesheet">
    <link
        href="https://fonts.googleapis.com/css2?family=Anek+Odia:wght@200&family=Blinker:wght@200&family=Prompt:wght@200&family=Staatliches&display=swap"
        rel="stylesheet">
    <style>
        header {
            text-align: center;
            text-decoration: underline;
            font-family: 'Anek Odia', sans-serif;
            font-family: 'Prompt', sans-serif;
            font-size: large;
            margin-left: 5%;
            margin-right: 5%;
            border-radius: 15px;
            background-color: rgb(240, 240, 240, 90%);
        }

        #resultlink {
            text-align: center;
        }

        a {
            color: white;

        }

        body {
            background-color: rgb(162, 191, 207, 80%);

        }

        form {
            background-color: rgb(240, 240, 240, 90%);
            padding: 3%;
            border-radius: 20px;
            margin-left: 15%;
            margin-right: 15%;
            font-family: 'Anek Odia', sans-serif;
            font-size: large;
        }

        .questioncontainer {
            margin-top: 2%;
            padding-left: 3%;
            border-style: solid;
            border-radius: 20px;
            border-color: black;
        }

        #prognum,
        #progdiff {
            width: 5%;
        }

        #nickname,
        #favboss,
        #removeclass {
            width: 25%;
        }

        .inputs {
            height: 35px;
        }

        #whyremove {
            width: 45%;
            height: 100px;
            resize: none;
        }

        #submit {
            font-family: 'Anek Odia', sans-serif;
            font-family: 'Prompt', sans-serif;
            border-radius: 15px;
            font-size: large;
            background-color: rgba(185, 197, 204, 0.5);
            background-size: contain;
            width: 80px;
            height: 50px;
        }
    </style>
</head>

<body>
    <div id="resultlink">
        <a href="/vastaukset">Just show me the results</a>
    </div>
    <header>
        <div id="headerh2">
            <h1>Not quite google forms but this will do</h1>
        </div>

    </header>

    <form action="/" method="post">
        <div class="questioncontainer">
            <p>Nickname (anything rly): <br>
                <input id="nickname" type="text" class="inputs" name="nickname"/>
            </p>
        </div>
        <div class="questioncontainer">
            <p>Approximately how many hours have you played wow in the past 2 weeks?<br>
                <input id="hoursplayed" type="number" class="inputs" name="hoursplayed"/>
                <br>
            </p>
        </div>
        <div class="questioncontainer">
            <p>SFO raid progression<br>
                <select id="progressnum" class="inputs" name="progressnum">
                    <option value=""></option>
                    <option value=1>1</option>
                    <option value=2>2</option>
                    <option value=3>3</option>
                    <option value=4>4</option>
                    <option value=5>5</option>
                    <option value=6>6</option>
                    <option value=7>7</option>
                    <option value=8>8</option>
                    <option value=9>9</option>
                    <option value=10>10</option>
                    <option value=11>11</option>
                </select>
                <label>/11 </label>
                <select id="progressdiff" class="inputs" name="progressdiff">
                    <option value="LFR">LFR</option>
                    <option value="N">N</option>
                    <option value="HC">HC</option>
                    <option value="M">M</option>
                </select>
            </p>
        </div>
        <div class="questioncontainer">
            <p>Favorite boss (any difficulty):<br>
                <select id="favboss" class="inputs" name="favboss">
                    <option value=""></option>
                    <option value="Guardian">Vigilant guardian</option>
                    <option value="Skolex">Skolex, the insatiable ravener</option>
                    <option value="Artificer">Artificer Xy'mox</option>
                    <option value="Dausegne">Dausegne the fallen oracle</option>
                    <option value="Pantheon">Prototype pantheon</option>
                    <option value="Lihuvim">Lihuvim the principal architect</option>
                    <option value="Halondrus">Halondrus the reclaimer (monkas)</option>
                    <option value="Anduin">Anduin Wrynn</option>
                    <option value="Dreads">Lords of dread</option>
                    <option value="Rygelon">Rygelon</option>
                    <option value="Jailer">The Jailer</option>
                </select>
            </p>
        </div>
        <div class="questioncontainer">
            <p>What's your M+ score?<br>
                <input id="mplus" type="number" class="inputs" name="mplus"/>
            </p>
        </div>
        <div class="questioncontainer">
            <p>Do you play pvp?<br>
                <input type="radio" id="yespvp" name="playpvp" value=1><label for="yes">YES</label>
                <input type="radio" id="nopvp" name="playpvp" value=0><label for="no">NO</label>
            </p>
        </div>
        <div class="questioncontainer">
            <p>If you had to choose one class to remove from the game which one would it be<br>
                <select id="removeclass" class="inputs" name="removeclass">
                    <option value=""></option>
                    <option value="hunter">Hunter</option>
                    <option value="rogue">Rogue</option>
                    <option value="mage">Mage</option>
                    <option value="warlock">Warlock</option>
                    <option value="warrior">Warrior</option>
                    <option value="paladin">Paladin</option>
                    <option value="priest">Priest</option>
                    <option value="druid">Druid</option>
                    <option value="shaman">Shaman</option>
                    <option value="dk">Death knight</option>
                    <option value="monk">Monk</option>
                    <option value="dh">Demon hunter</option>
                    <option value="evoker">Evoker????</option>
                </select><br>
                <label>Why? (max 150 chars)</label><br>
                <textarea id="whyremove" type="text" name="whyremove"></textarea>
            </p>
        </div>
        <div class="questioncontainer">
            <p>Finally, are you excited for the new Expansion "Dragonflight"?<br>
                <input type="radio" id="yesxpac" name="expachype" value=1><label for="yes">YES</label>
                <input type="radio" id="noxpac" name="expachype" value=0><label for="no">NO</label>
            </p>
        </div>
        <br>
        <div>
            <input type="submit" value="Submit" id="submit">
        </div>
    </form>

</body>

</html>