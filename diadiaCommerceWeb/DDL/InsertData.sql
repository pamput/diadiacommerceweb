INSERT INTO clienti (nome,indirizzo,codice,partitaiva,id)
VALUES (
'Mario Rossi',
'Via Roma 45',
1,
'MRRSS',
1
);

INSERT INTO clienti (nome,indirizzo,codice,partitaiva,id)
VALUES (
'Paolo Verdi',
'Via Veneto 12c',
2,
'PLVRD',
2
);

INSERT INTO clienti (nome,indirizzo,codice,partitaiva,id)
VALUES (
'Maria Bruni',
'Via Europa 55',
3,
'MRBRN',
3
);

INSERT INTO fornitori (nome,indirizzo,telefono,id)
VALUES (
'ACER',
'Via acer 33',
06000000,
1
);

INSERT INTO fornitori (nome,indirizzo,telefono,id)
VALUES (
'Toshiba',
'Via toshiba 22',
06101010,
2
);

INSERT INTO fornitori (nome,indirizzo,telefono,id)
VALUES (
'Hewlett-Packard',
'Via hp 90',
020202020,
3
);

INSERT INTO fornitori (nome,indirizzo,telefono,id)
VALUES (
'Sony',
'Via sony 1',
03000000,
4
);

INSERT INTO prodotti (codice,nome,descrizione,prezzo,quantita,id)
VALUES (
'L350',
'SATELLITE L350-17R',
'Il Satellite L350-17R è il laptop widescreen da 17 pollici ideale per le persone che desiderano una combinazione di grande impatto e affidabilità. Le sue funzionalità consentono un esperienza multimediale senza compromessi.',
499,
1,
1
);

INSERT INTO prodotti (codice,nome,descrizione,prezzo,quantita,id)
VALUES (
'U400',
'SATELLITE U400-17J',
'Il notebook Toshiba Satellite U400-17J, vi stupirà grazie all impatto estetico di assoluta rilevanza. Riuscirete a trasportare con facilità questo gioiellino grazie al peso decisamente ridotto (meno di 2kg) e grazie al Toshiba Face Recognition avrete la possibilità di connettervi con facilità al sistema operativo. ',
579,
12,
2
);

INSERT INTO prodotti (codice,nome,descrizione,prezzo,quantita,id)
VALUES (
'NS21S',
'Sony - VGN-NS21S/S',
'Il notebook Sony Vaio VGN-NS21S/S è il modello di fascia intermedia della nuova linea di laptop Sony Vaio NS da 15.4 pollici. Caratterizzato da una elegante rifinitura e dal colore Silver.',
588,
3,
3
);

INSERT INTO prodotti (codice,nome,descrizione,prezzo,quantita,id)
VALUES (
'D150X',
'ACER - ASPIRE ONE D150X-1BW WHITE',
'Netbook Acer Aspire One D150X-1BW, non solo piccolo ma anche trendy . Profilo sottile, contorni dolci e finiture pregiate. Perfetta fusione di estetica e funzionalità.',
278,
34,
4
);

INSERT INTO prodotti (codice,nome,descrizione,prezzo,quantita,id)
VALUES (
'5230',
'ACER - EXTENSA 5230-571G16MN',
'Notebook Acer Extensa 5230-571G16MN Celeron 575 2.0 Ghz, Ram 1 gb, Hard Disk 160 Gb, Display 15,4" WXGA, Grafica: Intel GMA 4500M , DVD SuperMulti DL, Modem 56Kbps, Lan 10/100/1000, WIFI 802.11b/g/Draft-N, Vista Home Basic.',
281,
23,
5
);

INSERT INTO prodotti (codice,nome,descrizione,prezzo,quantita,id)
VALUES (
'HP550',
'HP - HP550 - NA948EA',
'Notebook HP550 NA948EA, buone prestazioni, dotazioni professionale, e display da 15,4" abbinate alla giusta autonomia; il tutto a un prezzo mini.',
281,
34,
6
);

INSERT INTO fornisce (idfornitore,idprodotto)
VALUES (
2,
1
);

INSERT INTO fornisce (idfornitore,idprodotto)
VALUES (
2,
2
);

INSERT INTO fornisce (idfornitore,idprodotto)
VALUES (
4,
3
);

INSERT INTO fornisce (idfornitore,idprodotto)
VALUES (
1,
4
);

INSERT INTO fornisce (idfornitore,idprodotto)
VALUES (
1,
5
);

INSERT INTO fornisce (idfornitore,idprodotto)
VALUES (
3,
6
);

INSERT INTO accounts (idcliente,username,password,tipo)
VALUES (
1,
'Mario',
'7fd9a94f143d2bd19e98b3844a45d3ac',
'user'
);

INSERT INTO accounts (idcliente,username,password,tipo)
VALUES (
2,
'Paolo',
'1d148d0aaf717aa777c4758bbdd748b8',
'user'
);

INSERT INTO accounts (username,password,tipo)
VALUES (
'admin',
'21232f297a57a5a743894a0e4a801fc3',
'admin'
);
