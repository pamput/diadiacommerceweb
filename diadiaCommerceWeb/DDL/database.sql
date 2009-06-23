-- Tabella Clienti
CREATE TABLE clienti (
    codice text NOT NULL,
    nome text,
    partitaiva text,
    indirizzo text,
    id integer NOT NULL
);

ALTER TABLE public.clienti OWNER TO postgres;

ALTER TABLE ONLY clienti
    ADD CONSTRAINT clienti_codice_key UNIQUE (codice);

ALTER TABLE ONLY clienti
    ADD CONSTRAINT pk_clienti PRIMARY KEY (id);

CREATE VIEW "Clienti" AS
    SELECT clienti.codice, clienti.nome, clienti.partitaiva, clienti.indirizzo, clienti.id FROM clienti;

ALTER TABLE public."Clienti" OWNER TO postgres;

-- Tabella ordini
CREATE TABLE ordini (
    id integer NOT NULL,
    idcliente integer,
    data date NOT NULL,
    stato text NOT NULL,
    codice text
);

ALTER TABLE public.ordini OWNER TO postgres;

ALTER TABLE ONLY ordini
    ADD CONSTRAINT ordini_codice_key UNIQUE (codice);

ALTER TABLE ONLY ordini
    ADD CONSTRAINT ordini_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ordini
    ADD CONSTRAINT ordini_idcliente_fkey FOREIGN KEY (idcliente) REFERENCES clienti(id) ON UPDATE CASCADE ON DELETE CASCADE;

CREATE VIEW "Ordini" AS
    SELECT ordini.id, ordini.idcliente, ordini.data, ordini.stato, ordini.codice FROM ordini;

ALTER TABLE public."Ordini" OWNER TO postgres;

-- Tabella Prodotti
CREATE TABLE prodotti (
    codice text NOT NULL,
    nome text,
    descrizione text,
    prezzo integer,
    quantita integer,
    id integer NOT NULL
);

ALTER TABLE public.prodotti OWNER TO postgres;

ALTER TABLE ONLY prodotti
    ADD CONSTRAINT pk_prodotti PRIMARY KEY (id);

ALTER TABLE ONLY prodotti
    ADD CONSTRAINT prodotti_codice_key UNIQUE (codice);

CREATE VIEW "Prodotti" AS
    SELECT prodotti.codice, prodotti.nome, prodotti.descrizione, prodotti.prezzo, prodotti.quantita, prodotti.id FROM prodotti;

ALTER TABLE public."Prodotti" OWNER TO postgres;

-- Tabella accounts
CREATE TABLE accounts (
    idcliente integer,
    username text NOT NULL,
    password text NOT NULL,
    tipo text NOT NULL
);

ALTER TABLE public.accounts OWNER TO postgres;

ALTER TABLE ONLY accounts
    ADD CONSTRAINT accounts_username_key UNIQUE (username);

-- Tabella fornitori
CREATE TABLE fornitori (
    id integer NOT NULL,
    nome text NOT NULL,
    indirizzo text NOT NULL,
    telefono text NOT NULL
);

ALTER TABLE ONLY fornitori
    ADD CONSTRAINT fornitori_nome_key UNIQUE (nome);

ALTER TABLE ONLY fornitori
    ADD CONSTRAINT fornitori_pkey PRIMARY KEY (id);

ALTER TABLE public.fornitori OWNER TO postgres;

-- Tabella fornisce
CREATE TABLE fornisce (
    idfornitore integer,
    idprodotto integer
);

ALTER TABLE public.fornisce OWNER TO postgres;

ALTER TABLE ONLY fornisce
    ADD CONSTRAINT fornisce_idprodotto_fkey FOREIGN KEY (idprodotto) REFERENCES prodotti(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY fornisce
    ADD CONSTRAINT fornisce_idfornitore_fkey FOREIGN KEY (idfornitore) REFERENCES fornitori(id) ON UPDATE CASCADE ON DELETE CASCADE;

-- Tabella righe ordine
CREATE TABLE righeordine (
    id integer NOT NULL,
    idordine integer NOT NULL,
    idprodotto integer NOT NULL,
    numeroriga integer NOT NULL,
    quantita integer NOT NULL
);

ALTER TABLE ONLY righeordine
    ADD CONSTRAINT righeordine_pkey PRIMARY KEY (id);

ALTER TABLE ONLY righeordine
    ADD CONSTRAINT righeordine_idordine_fkey FOREIGN KEY (idordine) REFERENCES ordini(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY righeordine
    ADD CONSTRAINT righeordine_idprodotto_fkey FOREIGN KEY (idprodotto) REFERENCES prodotti(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE public.righeordine OWNER TO postgres;

-- Sequenze
CREATE SEQUENCE sequenzaclienti
    START WITH 6
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER TABLE public.sequenzaclienti OWNER TO postgres;

CREATE SEQUENCE sequenzafornitori
    START WITH 6
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER TABLE public.sequenzafornitori OWNER TO postgres;

CREATE SEQUENCE sequenzaordini
	START WITH 6
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER TABLE public.sequenzaordini OWNER TO postgres;

CREATE SEQUENCE sequenzaprodotti
    START WITH 6
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER TABLE public.sequenzaprodotti OWNER TO postgres;

CREATE SEQUENCE sequenzacodiceordine
    START WITH 6
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER TABLE public.sequenzacodiceordine OWNER TO postgres;

CREATE SEQUENCE sequenzarigheordine
    START WITH 12
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER TABLE public.sequenzarigheordine OWNER TO postgres;

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

-- Inserimento dati ---
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

INSERT INTO ordini (id,idcliente,data,stato,codice)
VALUES (
1,
1,
'25/01/09',
'evaso',
'ORD1'
);

INSERT INTO ordini (id,idcliente,data,stato,codice)
VALUES (
2,
2,
'12/12/09',
'chiuso',
'ORD2'
);

INSERT INTO ordini (id,idcliente,data,stato,codice)
VALUES (
3,
1,
'09/09/09',
'chiuso',
'ORD3'
);

INSERT INTO righeordine (id,idprodotto,idordine,numeroriga,quantita)
VALUES (
1,
2,
1,
1,
3
);

INSERT INTO righeordine (id,idprodotto,idordine,numeroriga,quantita)
VALUES (
2,
4,
1,
2,
4
);

INSERT INTO righeordine (id,idprodotto,idordine,numeroriga,quantita)
VALUES (
3,
3,
2,
1,
3
);

INSERT INTO righeordine (id,idprodotto,idordine,numeroriga,quantita)
VALUES (
4,
5,
2,
2,
7
);

INSERT INTO righeordine (id,idprodotto,idordine,numeroriga,quantita)
VALUES (
5,
2,
3,
1,
1
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
