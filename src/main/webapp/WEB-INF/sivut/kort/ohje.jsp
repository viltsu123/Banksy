<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ohjesivu</title>
</head>
<body>
	<h3>Tietoa sivun toiminnasta</h3>
	<br>
	<p>Tervetuloa minun keksitylle pankkipalvelu sivulle. Jätän tähän nuo omat tunnarit koska palvelu ei 
	luo tauluja. Ensiksi listaus palvelun toiminnallisuuksista:</p>
	<br>
	<ul>
		<li>Voit lisätä kortteja tietokantaan</li>
		<li>Voit hakea kortteja id perusteella</li>
		<li>Voit hakea korttien tapahtumia</li>
		<li>Voit hakea korttien tapahtumia korttinumeron perusteella</li>
		<li>Voit hakea pankin kaikki asiakkaat tietokannasta</li>
		<li>Voit lisätä ja ottaa rahaa korteilta</li>
		<li>Voit poistaa kortillisia kannasta korttinumeron perusteella</li>
	</ul>
	<br>
	<p>Eli asiakkaat ovat "kortillisia" tässä palvelussa. Lisäys
		hetkellä kysytään vain etu- ja sukunimi jonka jälkeen asiakas saa
		kahdeksan numeroisen korttinumeron. Tällä numerolla sitten käytetään
		pankin eri palveluita. Pankin sivuille ei voi kirjautua joten näkymä
		mikä on tällä hetkellä on admin näkymä. Käytössä on kaksi tietokanta-
		taulua jotka eivät ole yhteydessä toisiinsa. Korttinumero on tosin
		sama kummassakin taulussa, ja tapahtumien haku onnistuu sen
		perusteella. Pientä validointia olen käyttänyt tuossa asiakkaan
		lisäämis kohdassa. Myös noissa kohdissa joissa ei ole tietoa
		näytettävissä olen käyttänyt tuota "c" tagin tuomia toiminnallisuuksia
		jsp puolella piilottaakseni tyhjiä tauluja yms. Tuo näkyy kun haet id
		perusteella kortillsia ja id ei palauta mitään. Asia mikä jäi
		ratkaisematta oli tuo tiedon välittäminen toiselta jsp sivulta
		seuraavalle ilman formia. Tuo olisi helpottanut montaa toimintoa
		palvelussa, kun kaikki niin paljon tapahtuu korttinumeron perusteella.
		Tässä on paljon sivuja kontrolloitavaksi ja ajoittain se myös sotki
		omat ajatukset. Kirjautumisen jätin pois tuosta syystä, koska olisin
		joutunut rikkomaan sivujen rakennetta niin paljon että olisin
		todennäköisesti rikkonut palvelun. En myöskään käyttänyt REST
		palveluja tässä koska koin että tämä on nyt riittävän hyvä. Käytössä
		on kuitenkin niiiiiiin paljon kaikenlaista :)</p>
	<br>
	<br>
	<a href="tapahtuma">Näytä henkilön kortintapahtumat</a>
	<br>
	<br>
	<a href="hae">Kannassa just nyt</a>
	<br>
	<br>
	<a href="id">Hae id perusteella kortillisia</a>
	<br>
	<br>
	<a href="haetapahtumat">Kaikki Pankintapahtumat</a>
	<br>
	<br>
	<a href="koti">Etusivulle</a>
</body>
</html>