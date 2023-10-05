CREATE TABLE `inscricao` (
    `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `data` datetime(6) NOT NULL,
    `evento_id` bigint NOT NULL,
    `usuario_id` bigint NOT NULL,
    FOREIGN KEY (`evento_id`) REFERENCES `evento` (`id`),
    FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
);