BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "cliente" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"nome"	VARCHAR(80) NOT NULL,
	"email"	VARCHAR(40) NOT NULL,
	"telefone"	INT
);
INSERT INTO "cliente" VALUES (1,'Betty','betty@techcamps.com',12345678);
INSERT INTO "cliente" VALUES (2,'Theo Cauã Castro','theo-castro71@gerador.com.br',11988878365);
INSERT INTO "cliente" VALUES (3,'Mário Lucas Kaique da Silva','mario_dasilva@gerador.com.br',11986368224);
INSERT INTO "cliente" VALUES (4,'Lúcia Simone Raimunda Teixeira','lucia_simone_teixeira@gerador.com.br',11988869120);
INSERT INTO "cliente" VALUES (5,'Maitê Giovanna da Mata','maite_giovanna_damata@gerador.com.br',11989458599);
INSERT INTO "cliente" VALUES (6,'Isabelle Manuela Martins','isabelle_manuela_martins@gerador.com.br',11983562447);
INSERT INTO "cliente" VALUES (7,'Mariah Amanda Manuela Pereira','mariahamandapereira@gerador.com.br',11997490614);
INSERT INTO "cliente" VALUES (8,'Fernando Vinicius Theo Costa','fernando_vinicius_costa@gerador.com.br',11984949588);
INSERT INTO "cliente" VALUES (9,'Lucas Luan Cláudio Alves','lucas_luan_alves@gerador.com.br',11982783082);
INSERT INTO "cliente" VALUES (10,'Mirella Elaine Luiza Pires','mirellaelainepires@gerador.com.br',11986324878);
INSERT INTO "cliente" VALUES (11,'Osvaldo Raimundo Martins','osvaldo_martins@gerador.com.br',11996198182);
INSERT INTO "cliente" VALUES (12,'Bárbara Beatriz Gabriela da Paz','barbara_dapaz@gerador.com.br',11985432113);
COMMIT;
