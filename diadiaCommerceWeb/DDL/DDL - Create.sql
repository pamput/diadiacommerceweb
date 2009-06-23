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
    START WITH 16
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER TABLE public.sequenzarigheordine OWNER TO postgres;

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
