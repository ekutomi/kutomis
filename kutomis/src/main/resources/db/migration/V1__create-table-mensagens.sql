CREATE TABLE public.tb_tipo_mensagem (
	id_tipo int4 NOT NULL,
	ds_tipo varchar NOT NULL,
	CONSTRAINT tb_tipo_mensagem_pk PRIMARY KEY (id_tipo)
);

CREATE TABLE public.tb_usuario (
	id_usuario int4 NOT NULL,
	nm_nome varchar NOT NULL,
	nm_sobrenome varchar NULL,
	nm_email varchar NOT NULL,
	nm_telefone varchar NULL,
	bl_foto_perfil varchar NULL,
	CONSTRAINT tb_usuario_pk PRIMARY KEY (id_usuario)
);

CREATE TABLE public.tb_mensagem (
	id int8 NOT NULL DEFAULT nextval('id_serial'::regclass),
	id_usuario int4 NOT NULL,
	mensagem varchar NOT NULL,
	id_tipo int4 NOT NULL,
	CONSTRAINT tb_mensagem_pk PRIMARY KEY (id),
	CONSTRAINT tb_mensagem_fk FOREIGN KEY (id_usuario) REFERENCES public.tb_usuario(id_usuario),
	CONSTRAINT tb_tipo_mensagem_fk FOREIGN KEY (id_tipo) REFERENCES public.tb_tipo_mensagem(id_tipo)
);

