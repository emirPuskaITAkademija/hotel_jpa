# Hotel Management Sistem

## Dva segmenta aplikacije
1. **Biznis segment**
2. **Tehnički segment**

---
## Biznis Segment

### Opis Informacionog Sistema
Sistem koji vode zaposleni u hotelu za vođenje rezervacija
soba. Ova aplikacija **polizatvorenog tipa**:
- **Uposleni** će vidjeti detalje o gostima.
- **Korisnici bez punog pristupa** mogu vidjeti samo dostupnost soba.

Za početak, fokusiramo se na to da aplikaciju koriste
**samo uposlenici hotela**.

### Funkcionalnosti sistema
Hotel vodi evidenciju o **sobama**:
 - Svaka soba ima definisan **broj gostiju** koji u njoj mogu boraviti
Sistem rezervacije funkcioniše na **4 parametra**:
 - `fromDate`
 - `toDate`
 - `checkin`
 - `checkout`

 Za svaku rezervaciju moraju postojati:
 1. Informacije o **gostu** na kog se vodi rezervacija.
 2. Informacije o **ostalim gostima** u sobi.

### Podaci o gostima
Za svakog gosta se čuva :
- **ime** i **prezime**
- **broj pasoša/lične karte**

### Nivoi pristupa
Sistem za početak ima **2 nivoa pristupa**:
1. **Administrator**
    - može dodavati i brisati sobe.
2. **Employee**
    - Može upravljati rezervacijama.
> Više rezervacija jedne sobe se **ne smiju** preklapati !

---
## Tehnički segment
### Tehnologije koje će se koristiti u projektu:
1. **JavaFx** - za frontend dio aplikacije(Desktop App)
2. **MySQL** - relaciona baza podataka
3. **JPA + ORM** (ORM -> Hibernate/Eclipselink/MyBatis) - za most između baze i aplikacije

---
## Kako doprinijeti ? 
Ako želiš da doprineseš razvoju ove aplikacije slobodni otvori **issue** ili **pull request**! :-)