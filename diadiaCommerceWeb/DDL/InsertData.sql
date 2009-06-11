INSERT INTO clienti (nome,indirizzo,codice,id)
VALUES (
'Mario Rossi',
'Via Roma 45',
1,
nextval('sequenzaclienti')
);

INSERT INTO clienti (nome,indirizzo,codice,id)
VALUES (
'Paolo Verdi',
'Via Veneto 12c',
2,
nextval('sequenzaclienti')
);

INSERT INTO clienti (nome,indirizzo,codice,id)
VALUES (
'Maria Bruni',
'Via Europa 55',
3,
nextval('sequenzaclienti')
);

INSERT INTO fornitori (nome,indirizzo,telefono,id)
VALUES (
'Post srl',
'Via qualcosa 33',
06000000,
nextval('sequenzafornitori')
);

INSERT INTO fornitori (nome,indirizzo,telefono,id)
VALUES (
'Gre spa',
'Via mboh 22',
06101010,
nextval('sequenzafornitori')
);

INSERT INTO fornitori (nome,indirizzo,telefono,id)
VALUES (
'Forniamo ltd',
'Via dove 90',
020202020,
nextval('sequenzafornitori')
);

INSERT INTO prodotti (codice,nome,descrizione,prezzo,quantita,id)
VALUES (
'ASD1',
'Clorofibrina',
'Asdante dai sda skoma',
45,
1,
nextval('sequenzaprodotti')
);

INSERT INTO prodotti (codice,nome,descrizione,prezzo,quantita,id)
VALUES (
'ASD2',
'Criogenina',
'Criogenizzante',
178,
12,
nextval('sequenzaprodotti')
);

INSERT INTO prodotti (codice,nome,descrizione,prezzo,quantita,id)
VALUES (
'ASD3',
'Fluoronina',
'seeeeeeeeeeeeee',
78,
3,
nextval('sequenzaprodotti')
);

INSERT INTO accounts (idcliente,username,password,tipo)
VALUES (
1,
'user',
'user',
'user'
);

INSERT INTO accounts (username,password,tipo)
VALUES (
'admin',
'admin',
'admin'
);
