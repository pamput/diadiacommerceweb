--
-- PostgreSQL database dump
--

-- Started on 2009-06-11 17:09:18

SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 319 (class 2612 OID 16386)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1491 (class 1259 OID 17379)
-- Dependencies: 6
-- Name: clienti; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE clienti (
    codice text NOT NULL,
    nome text,
    partitaiva text,
    indirizzo text,
    id integer NOT NULL
);


ALTER TABLE public.clienti OWNER TO postgres;

--
-- TOC entry 1492 (class 1259 OID 17385)
-- Dependencies: 1581 6
-- Name: Clienti; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW "Clienti" AS
    SELECT clienti.codice, clienti.nome, clienti.partitaiva, clienti.indirizzo, clienti.id FROM clienti;


ALTER TABLE public."Clienti" OWNER TO postgres;

--
-- TOC entry 1493 (class 1259 OID 17389)
-- Dependencies: 6
-- Name: ordini; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ordini (
    id integer NOT NULL,
    idcliente integer,
    data date NOT NULL,
    stato text NOT NULL,
    codice text
);


ALTER TABLE public.ordini OWNER TO postgres;

--
-- TOC entry 1494 (class 1259 OID 17395)
-- Dependencies: 1582 6
-- Name: Ordini; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW "Ordini" AS
    SELECT ordini.id, ordini.idcliente, ordini.data, ordini.stato, ordini.codice FROM ordini;


ALTER TABLE public."Ordini" OWNER TO postgres;

--
-- TOC entry 1496 (class 1259 OID 17405)
-- Dependencies: 6
-- Name: prodotti; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE prodotti (
    codice text NOT NULL,
    nome text,
    descrizione text,
    prezzo integer,
    quantita integer,
    id integer NOT NULL
);


ALTER TABLE public.prodotti OWNER TO postgres;

--
-- TOC entry 1497 (class 1259 OID 17411)
-- Dependencies: 1583 6
-- Name: Prodotti; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW "Prodotti" AS
    SELECT prodotti.codice, prodotti.nome, prodotti.descrizione, prodotti.prezzo, prodotti.quantita, prodotti.id FROM prodotti;


ALTER TABLE public."Prodotti" OWNER TO postgres;

--
-- TOC entry 1495 (class 1259 OID 17399)
-- Dependencies: 6
-- Name: accounts; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE accounts (
    idcliente integer,
    username text NOT NULL,
    password text NOT NULL,
    tipo text NOT NULL
);


ALTER TABLE public.accounts OWNER TO postgres;

--
-- TOC entry 1498 (class 1259 OID 17415)
-- Dependencies: 6
-- Name: fornisce; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fornisce (
    idfornitore integer,
    idprodotto integer
);


ALTER TABLE public.fornisce OWNER TO postgres;

--
-- TOC entry 1499 (class 1259 OID 17418)
-- Dependencies: 6
-- Name: fornitori; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fornitori (
    id integer NOT NULL,
    nome text NOT NULL,
    indirizzo text NOT NULL,
    telefono text NOT NULL
);


ALTER TABLE public.fornitori OWNER TO postgres;

--
-- TOC entry 1500 (class 1259 OID 17424)
-- Dependencies: 6
-- Name: righeordine; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE righeordine (
    id integer NOT NULL,
    idordine integer NOT NULL,
    idprodotto integer NOT NULL,
    numeroriga integer NOT NULL,
    quantita integer NOT NULL
);


ALTER TABLE public.righeordine OWNER TO postgres;

--
-- TOC entry 1501 (class 1259 OID 17427)
-- Dependencies: 6
-- Name: sequenzaclienti; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sequenzaclienti
    START WITH 5
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sequenzaclienti OWNER TO postgres;

--
-- TOC entry 1814 (class 0 OID 0)
-- Dependencies: 1501
-- Name: sequenzaclienti; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sequenzaclienti', 5, false);


--
-- TOC entry 1502 (class 1259 OID 17429)
-- Dependencies: 6
-- Name: sequenzafornitori; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sequenzafornitori
    START WITH 4
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sequenzafornitori OWNER TO postgres;

--
-- TOC entry 1815 (class 0 OID 0)
-- Dependencies: 1502
-- Name: sequenzafornitori; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sequenzafornitori', 4, false);


--
-- TOC entry 1503 (class 1259 OID 17431)
-- Dependencies: 6
-- Name: sequenzaordini; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sequenzaordini
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sequenzaordini OWNER TO postgres;

--
-- TOC entry 1816 (class 0 OID 0)
-- Dependencies: 1503
-- Name: sequenzaordini; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sequenzaordini', 3, true);


--
-- TOC entry 1504 (class 1259 OID 17433)
-- Dependencies: 6
-- Name: sequenzaprodotti; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sequenzaprodotti
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sequenzaprodotti OWNER TO postgres;

--
-- TOC entry 1817 (class 0 OID 0)
-- Dependencies: 1504
-- Name: sequenzaprodotti; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sequenzaprodotti', 7, true);


--
-- TOC entry 1505 (class 1259 OID 17435)
-- Dependencies: 6
-- Name: sequenzarigheordine; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sequenzarigheordine
    START WITH 5
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sequenzarigheordine OWNER TO postgres;

--
-- TOC entry 1818 (class 0 OID 0)
-- Dependencies: 1505
-- Name: sequenzarigheordine; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sequenzarigheordine', 5, false);


--
-- TOC entry 1804 (class 0 OID 17399)
-- Dependencies: 1495
-- Data for Name: accounts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY accounts (idcliente, username, password, tipo) FROM stdin;
3	user	user	user
1	gianpaolo	ee354e5041859e9724c04de9abad57da	user
1	asdasdasd	ee354e5041859e9724c04de9abad57da	user
2	adwadawdawda	92569541408f67e65e6df18b108c8de3	user
2	DSADWADAWD	82c4b5179d2eaae6e75cd692860a4159	user
2	LUCILLO	f9655638583f2b037d54a0d94cdea1f0	user
2	allora	13423b2996d1e5b237ff8265d2ca743e	user
2	davide	446fca5553df49ad9c6348cf1ff71d51	user
3	lukasz	d7559b8c502dea1b5323af444e81e014	user
0	admin	21232f297a57a5a743894a0e4a801fc3	admin
\.


--
-- TOC entry 1802 (class 0 OID 17379)
-- Dependencies: 1491
-- Data for Name: clienti; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY clienti (codice, nome, partitaiva, indirizzo, id) FROM stdin;
UNO	Mario Rossi	PIVA1	Via Qualcosa	1
DUE	Marco Verdi	PIVA2	Via Dove	2
TRE	Giovanni Blu	PIVA3	Via Quando	3
QUATTRO	Claudia Celeste	PIVA4	Via Perchè	4
\.


--
-- TOC entry 1806 (class 0 OID 17415)
-- Dependencies: 1498
-- Data for Name: fornisce; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY fornisce (idfornitore, idprodotto) FROM stdin;
3	1
3	2
2	3
1	4
\.


--
-- TOC entry 1807 (class 0 OID 17418)
-- Dependencies: 1499
-- Data for Name: fornitori; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY fornitori (id, nome, indirizzo, telefono) FROM stdin;
1	ASUSTEK	Via Non Ricordo 23	092343212
2	CARAMELLE inc	Via Boh 23	082342311
3	ACME inc	Via Uhm 23	0390248902
\.


--
-- TOC entry 1803 (class 0 OID 17389)
-- Dependencies: 1493
-- Data for Name: ordini; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ordini (id, idcliente, data, stato, codice) FROM stdin;
1	1	2012-12-12	evaso	UNO
2	2	1990-11-19	chiuso	DUE
\.


--
-- TOC entry 1805 (class 0 OID 17405)
-- Dependencies: 1496
-- Data for Name: prodotti; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY prodotti (codice, nome, descrizione, prezzo, quantita, id) FROM stdin;
VINS	Vincenzo	L'unico ed originale	2	1	7
UNO	Crioptiogerina	Prodotto farmaceutico	150	17	1
DUE	Pneumatici R13	Pneumatici	50	4	2
TRE	Caramelle alla liquirizia	Prodotto alimentare	2	500	3
QUATTRO	AsusG50	Notebook	800	34	4
CINQUE	AsusG71	Notebook	1100	0	5
\.


--
-- TOC entry 1808 (class 0 OID 17424)
-- Dependencies: 1500
-- Data for Name: righeordine; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY righeordine (id, idordine, idprodotto, numeroriga, quantita) FROM stdin;
1	1	1	1	2
3	2	3	1	2
4	2	4	2	2
\.


--
-- TOC entry 1784 (class 2606 OID 17440)
-- Dependencies: 1495 1495
-- Name: accounts_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY accounts
    ADD CONSTRAINT accounts_username_key UNIQUE (username);


--
-- TOC entry 1776 (class 2606 OID 17438)
-- Dependencies: 1491 1491
-- Name: clienti_codice_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY clienti
    ADD CONSTRAINT clienti_codice_key UNIQUE (codice);


--
-- TOC entry 1790 (class 2606 OID 17442)
-- Dependencies: 1498 1498 1498
-- Name: fornisce_idprodotto_idfornitore_unique; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fornisce
    ADD CONSTRAINT fornisce_idprodotto_idfornitore_unique UNIQUE (idfornitore, idprodotto);


--
-- TOC entry 1792 (class 2606 OID 17446)
-- Dependencies: 1499 1499
-- Name: fornitori_nome_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fornitori
    ADD CONSTRAINT fornitori_nome_key UNIQUE (nome);


--
-- TOC entry 1794 (class 2606 OID 17444)
-- Dependencies: 1499 1499
-- Name: fornitori_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fornitori
    ADD CONSTRAINT fornitori_pkey PRIMARY KEY (id);


--
-- TOC entry 1780 (class 2606 OID 17473)
-- Dependencies: 1493 1493
-- Name: ordini_codice_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ordini
    ADD CONSTRAINT ordini_codice_key UNIQUE (codice);


--
-- TOC entry 1782 (class 2606 OID 17448)
-- Dependencies: 1493 1493
-- Name: ordini_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ordini
    ADD CONSTRAINT ordini_pkey PRIMARY KEY (id);


--
-- TOC entry 1778 (class 2606 OID 17450)
-- Dependencies: 1491 1491
-- Name: pk_clienti; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY clienti
    ADD CONSTRAINT pk_clienti PRIMARY KEY (id);


--
-- TOC entry 1786 (class 2606 OID 17452)
-- Dependencies: 1496 1496
-- Name: pk_prodotti; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY prodotti
    ADD CONSTRAINT pk_prodotti PRIMARY KEY (id);


--
-- TOC entry 1788 (class 2606 OID 17454)
-- Dependencies: 1496 1496
-- Name: prodotti_codice_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY prodotti
    ADD CONSTRAINT prodotti_codice_key UNIQUE (codice);


--
-- TOC entry 1796 (class 2606 OID 17456)
-- Dependencies: 1500 1500
-- Name: righeordine_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY righeordine
    ADD CONSTRAINT righeordine_pkey PRIMARY KEY (id);


--
-- TOC entry 1798 (class 2606 OID 17457)
-- Dependencies: 1793 1498 1499
-- Name: fornisce_idfornitore_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fornisce
    ADD CONSTRAINT fornisce_idfornitore_fkey FOREIGN KEY (idfornitore) REFERENCES fornitori(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1799 (class 2606 OID 17462)
-- Dependencies: 1498 1496 1785
-- Name: fornisce_idprodotto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fornisce
    ADD CONSTRAINT fornisce_idprodotto_fkey FOREIGN KEY (idprodotto) REFERENCES prodotti(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1797 (class 2606 OID 17467)
-- Dependencies: 1491 1493 1777
-- Name: ordini_idcliente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ordini
    ADD CONSTRAINT ordini_idcliente_fkey FOREIGN KEY (idcliente) REFERENCES clienti(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1800 (class 2606 OID 17474)
-- Dependencies: 1781 1493 1500
-- Name: righeordine_idordine_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY righeordine
    ADD CONSTRAINT righeordine_idordine_fkey FOREIGN KEY (idordine) REFERENCES ordini(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1801 (class 2606 OID 17479)
-- Dependencies: 1500 1496 1785
-- Name: righeordine_idprodotto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY righeordine
    ADD CONSTRAINT righeordine_idprodotto_fkey FOREIGN KEY (idprodotto) REFERENCES prodotti(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1813 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2009-06-11 17:09:18

--
-- PostgreSQL database dump complete
--

