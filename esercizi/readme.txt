note:

1- nel costruttore ctor MAI logica-
2- non si torna mai null

-----------------------------------------------------------------
da fare:
1-installare oracle xe
2-installare sqldeveloper

entri come sys/sys e crei utente test/test

grant all privileges to test identified by test
sloggi sys/sys
conneti come test

create table PERSONA (
  idPersona varchar(20) not null,
  Nome VARCHAR(30) NOT NULL,
  Cognome VARCHAR(30) NOT NULL,
  CodiceFisc VARCHAR(16) NOT NULL,
  Altezza NUMBER NOT NULL,
  Peso NUMBER NOT NULL
);

creare una sequenza:

create sequence seq;
select seq.nextval from dual;

prendere next da sequenza

drop user test2


-----------------------------------------------------------------
esercizio2

-----------------------------------------------------------------
http://www.mybatis.org/mybatis-3/

scarichi e installi libreria

leggi docs

implementi il dao con batis

-----------------------------------------------------------------

complichiamo il modello
relazioni 1-1, 1-N, N-M

Persona ha una lista di indirizzi

-----------------------------------------------------------------
teoria:
 java threads esempi e cosa sono

-----------------------------------------------------------------
UIWeb:

https://wicket.apache.org/
-----------------------------------------------------------------




