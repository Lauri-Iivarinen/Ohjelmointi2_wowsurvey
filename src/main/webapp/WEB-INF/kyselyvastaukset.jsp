<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        #resultlink,h3,h2 {
            text-align: center;
        }

        a {
            color: white;

        }

        body {
            background-color: rgb(162, 191, 207, 80%);

        }

        .results {
            background-color: rgb(240, 240, 240, 90%);
            padding: 3%;
            border-radius: 20px;
            margin-left: 15%;
            margin-right: 15%;
            
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
        
        #textresults{
        	width: 50%;
        	float: left;
        	text-align: center;
        	font-size: large;
        }
        
        #factcolor{
	        color: green;
	        font-size: larger;
        }
        
    </style>
</head>

<body>
	<!-- KUVAAJIEN LINKKI -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js">
    </script>
  
    <header>
        <div id="headerh2">
            <h1>Summary of the results:</h1>
        </div>

    </header>
    
    <!-- ----------------------------C:FOREACH ALKAA---------------------- -->
    
    <c:forEach items="${muotoiltu}" var="muotoiltu">
      
    	<!-- AVG PELATTU -->
    	<div class="results">
    		<h2>Average time played in the last 2 weeks</h2>
    		<h3><c:out value="${muotoiltu.avgplayed}"></c:out> hours</h3>
    		<br>
			<div id="textresults">
				<p id="fact1"></p>
			</div>
			<div id="textresults">
				<p id="fact2"></p>
			</div>
			<br>
			<br>
			<br>
		</div>
		<script>
			var hours = ${muotoiltu.avgplayed}
			var fact1hours = hours*360
			var fact2hours = hours*(25000/24)
			var text1 = "Lightning has struck the earth<br>approximately <label id='factcolor'>" +fact1hours.toFixed(0)+"</label><br> times during this time."
			var text2 = "Average human has blinked<br><label id='factcolor'>" + fact2hours.toFixed(0) + "</label> times during this time."
			document.getElementById("fact1").innerHTML = text1;
			document.getElementById("fact2").innerHTML = text2;
			console.log(text1)
			console.log(text2)
		</script>
		
		<!-- AVG MPLUS -->
		<div class="results">
			<h2>M+ player has an average of:</h2>
			<h3><c:out value="${muotoiltu.avgmplus}"></c:out> points</h3>
			<br>
			<div id="textresults">
			<p id="fact3"></p>
			</div>
			<div id="textresults">
			<p id="fact4"></p>
			</div>
			<br>
			<br>
		</div>
		<script>
		var points = ${muotoiltu.avgmplus}
		var text1 = ""
		
		if (points >= 3000){
			text1 = "Average player has all conduits upgraded to 278 =)"
		}else if (points >= 2500){
			text1 = "Mount is a mount even if its just a '+1'"
		}else if (points >= 2000){
			text1 = "That would be KSM on 9.1"
		}else{
			text1 = "Average player does not play m+ it seems"
		}
		document.getElementById("fact3").innerHTML = text1
		
		var text2 = ""
		var avgkeylevel = points /150
		
		text2 = "Average key level: " + avgkeylevel.toFixed(0) +"<br>(very rough estimate:D)"
		document.getElementById("fact4").innerHTML = text2
		
		
		</script>
		<!-- KUVAAJAT ALKAA -->
		<!-- FAVOURITE BOSS -->
		<div class="results">
		<h2>RAID:</h2>
        <canvas id="myChart" style="width:50%;"></canvas>
        <script>
            var xValues = ["Guardian", "Skolex", "Artificer","Halondrus","Dausegne","Pantheon","Lihuvim","Anduin","Dreads","Rygelon","Jailer"];
            var yValues = [${muotoiltu.favbossMap["Guardian"]},${muotoiltu.favbossMap["Skolex"]},${muotoiltu.favbossMap["Artificer"]}, ${muotoiltu.favbossMap["Halondrus"]},
            	${muotoiltu.favbossMap["Dausegne"]},${muotoiltu.favbossMap["Pantheon"]},${muotoiltu.favbossMap["Lihuvim"]},${muotoiltu.favbossMap["Anduin"]},
            	${muotoiltu.favbossMap["Dreads"]},${muotoiltu.favbossMap["Rygelon"]},${muotoiltu.favbossMap["Jailer"]},0];

            new Chart("myChart", {
                type: "bar",
                data: {
                    labels: xValues,
                    datasets: [{
                        backgroundColor: ['rgba(255, 99, 132, 0.5)',
                            'rgba(54, 162, 235, 0.5)','rgba(255, 99, 132, 0.5)',
                            'rgba(54, 162, 235, 0.5)','rgba(255, 99, 132, 0.5)',
                            'rgba(54, 162, 235, 0.5)','rgba(255, 99, 132, 0.5)',
                            'rgba(54, 162, 235, 0.5)','rgba(255, 99, 132, 0.5)',
                            'rgba(54, 162, 235, 0.5)','rgba(255, 99, 132, 0.5)',
                            'rgba(54, 162, 235, 0.5)'],
                            borderColor: [
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                
                            ],
                            borderWidth: 1,
                        data: yValues
                    }]
                },
                options: {
                	title: {
                		display: true, text: "Favourite bosses (all difficulties):"
                	},
                	legend: {
                		display: false
                	}
                	
                    
                }
            });
        </script>
    </div>
    <!-- UUSI KUVAAJA -->
    <!-- PROGRESS -->
    
     <div class="results">
        <canvas id="myChart5" style="width:50%;"></canvas>
        <script>
            var xValues = ["M","HC","N","LFR:3"];
            var yValues = [${muotoiltu.progM},${muotoiltu.progHc},${muotoiltu.progN},${muotoiltu.progLfr},0,10];

            new Chart("myChart5", {
                type: "horizontalBar",
                data: {
                    labels: xValues,
                    datasets: [{
                        backgroundColor: ["rgb(255,128,0)","rgb(163,53,238)","rgb(0,112,221)","rgb(30,255,0)"],
                            
                            borderWidth: 1,
                        data: yValues
                    }]
                },
                options: {
                	title: {
                		display: true, text: "Average progress on each difficulty (highest only)"
                	},
                	legend: {
                		display: false
                	}
                	
                    
                }
            });
        </script>
    </div>
    
   
    <!-- UUSI KUVAAJA -->
    <!-- PLAY PVP -->
    
    <div class="results">
        <canvas id="myChart2" style="width:50%;"></canvas>
        <script>
            var xValues = ["YES", "NO"];
            var yValues = [${muotoiltu.playpvpyes},${muotoiltu.playpvpno}];

            new Chart("myChart2", {
                type: "pie",
                data: {
                    labels: xValues,
                    datasets: [{
                        backgroundColor: ['rgba(102, 255, 51,0.5)','rgba(255, 55, 35, 0.5)'],
                            borderColor: [
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                
                            ],
                            borderWidth: 1,
                        data: yValues
                    }]
                },
                options: {
                	title: {
                		display: true, text: "Do you play PVP:D"
                	},
                	legend: {
                		display: true
                	}
                	
                    
                }
            });
        </script>
    </div>
    
    <!-- UUSI KUVAAJA -->
    
    <!-- REMOVE CLASS -->
    <div class="results">
        <canvas id="myChart4" style="width:50%;"></canvas>
        <script>
            var xValues = ["hunter","rogue", "mage","warlock","warrior","paladin","priest","druid","shaman","death knight","monk","demon hunter","evoker"];
            var yValues = [${muotoiltu.removeclassMap["hunter"]},${muotoiltu.removeclassMap["rogue"]},${muotoiltu.removeclassMap["mage"]},
            	${muotoiltu.removeclassMap["warlock"]},${muotoiltu.removeclassMap["warrior"]},${muotoiltu.removeclassMap["paladin"]},
            	${muotoiltu.removeclassMap["priest"]},${muotoiltu.removeclassMap["druid"]},${muotoiltu.removeclassMap["shaman"]},
            	${muotoiltu.removeclassMap["dk"]},${muotoiltu.removeclassMap["monk"]},${muotoiltu.removeclassMap["dh"]},${muotoiltu.removeclassMap["evoker"]},];

            new Chart("myChart4", {
                type: "polarArea",
                data: {
                    labels: xValues,
                    datasets: [{
                        backgroundColor: ['rgb(170,211,114)',"rgb(255,244,104)","rgb(63,199,235)","rgb(135,136,238)","rgb(198,155,109)",
                        	"rgb(244,140,186)","rgb(255,255,255)","rgb(255,124,10)","rgb(0,112,221)","rgb(196,30,58)",
                        	"rgb(0,255,152)","rgb(163,48,201)","rgb(51,147,127)"],
                            borderColor: [
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                
                            ],
                            borderWidth: 1,
                        data: yValues
                    }]
                },
                options: {
                	title: {
                		display: true, text: "Most hated class"
                	},
                	legend: {
                		display: false
                	}
                	
                    
                }
            });
        </script>
    </div>
    
    <!-- UUSI KUVAAJA -->
    <!-- EXPANSION HYPE -->
    <div class="results">
        <canvas id="myChart3" style="width:50%;"></canvas>
        <script>
            var xValues = ["YEEHAW", "NAH"];
            var yValues = [${muotoiltu.expachypeyes},${muotoiltu.expachypeno}];

            new Chart("myChart3", {
                type: "doughnut",
                data: {
                    labels: xValues,
                    datasets: [{
                    	 backgroundColor: ['rgba(23,180,100, 0.5)','rgba(150, 99, 132, 0.5)'],
                            borderColor: [
                                'rgba(0, 0, 0, 1)',
                                'rgba(0, 0, 0, 1)',
                                
                            ],
                            borderWidth: 1,
                        data: yValues
                    }]
                },
                options: {
                	title: {
                		display: true, text: "New expansion 'Dragonflight' hype:"
                	},
                	legend: {
                		display: true
                	}
                	
                    
                }
            });
        </script>
    </div>
	</c:forEach>
	

</body>
<footer>
<br>
	<div id="resultlink">
        <a href="/pwcheck">admin page;p</a>
    </div>
</footer>

</html>