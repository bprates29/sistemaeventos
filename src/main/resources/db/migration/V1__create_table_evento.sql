CREATE TABLE `evento` (
    `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `nome` varchar(255) NOT NULL,
    `data` date NOT NULL,
    `data_inicio_insc` datetime(6) NOT NULL,
    `data_fim_insc` datetime(6) NOT NULL,
    `descricao` varchar(255) DEFAULT NULL,
    `status` enum('ABERTO', 'CANCELADO', 'ENCERRADO', 'PREVISTO') DEFAULT NULL
);