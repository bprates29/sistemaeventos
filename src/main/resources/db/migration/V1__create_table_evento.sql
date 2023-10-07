CREATE TABLE `evento` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `data` date NOT NULL,
 `descricao` varchar(255) DEFAULT NULL,
 `nome` varchar(255) NOT NULL,
 `status` enum('ABERTO','CANCELADO','ENCERRADO','PREVISTO') DEFAULT NULL
);