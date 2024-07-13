-- DROP SCHEMA public;

-- CREATE SCHEMA public AUTHORIZATION pg_database_owner;
-- COMMENT ON SCHEMA public IS 'standard public schema';

-- DROP SEQUENCE public.course_seq;

CREATE SEQUENCE public.course_seq
	INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.golfer_seq;

CREATE SEQUENCE public.golfer_seq
	INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.score_seq;

CREATE SEQUENCE public.score_seq
	INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.scorecard_seq;

CREATE SEQUENCE public.scorecard_seq
	INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.tee_seq;

CREATE SEQUENCE public.tee_seq
	INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;-- public.course definition

-- Drop table

-- DROP TABLE public.course;

CREATE TABLE public.course (
	id int8 NOT NULL,
	city varchar(255) NULL,
	"name" varchar(255) NOT NULL,
	state varchar(255) NULL,
	CONSTRAINT course_pkey PRIMARY KEY (id)
);


-- public.golfer definition

-- Drop table

-- DROP TABLE public.golfer;

CREATE TABLE public.golfer (
	id int8 NOT NULL,
	email varchar(255) NULL,
	first_name varchar(255) NOT NULL,
	last_name varchar(255) NOT NULL,
	CONSTRAINT golfer_pkey PRIMARY KEY (id),
	CONSTRAINT uniqueindex UNIQUE (email)
);


-- public.scorecard definition

-- Drop table

-- DROP TABLE public.scorecard;

CREATE TABLE public.scorecard (
	id int8 NOT NULL,
	tee_time timestamp(6) NOT NULL,
	CONSTRAINT scorecard_pkey PRIMARY KEY (id)
);


-- public.tee definition

-- Drop table

-- DROP TABLE public.tee;

CREATE TABLE public.tee (
	hole10_dist int4 NULL,
	hole10_hdcp int4 NULL,
	hole10_par int4 NULL,
	hole11_dist int4 NULL,
	hole11_hdcp int4 NULL,
	hole11_par int4 NULL,
	hole12_dist int4 NULL,
	hole12_hdcp int4 NULL,
	hole12_par int4 NULL,
	hole13_dist int4 NULL,
	hole13_hdcp int4 NULL,
	hole13_par int4 NULL,
	hole14_dist int4 NULL,
	hole14_hdcp int4 NULL,
	hole14_par int4 NULL,
	hole15_dist int4 NULL,
	hole15_hdcp int4 NULL,
	hole15_par int4 NULL,
	hole16_dist int4 NULL,
	hole16_hdcp int4 NULL,
	hole16_par int4 NULL,
	hole17_dist int4 NULL,
	hole17_hdcp int4 NULL,
	hole17_par int4 NULL,
	hole18_dist int4 NULL,
	hole18_hdcp int4 NULL,
	hole18_par int4 NULL,
	hole1_dist int4 NULL,
	hole1_hdcp int4 NULL,
	hole1_par int4 NULL,
	hole2_dist int4 NULL,
	hole2_hdcp int4 NULL,
	hole2_par int4 NULL,
	hole3_dist int4 NULL,
	hole3_hdcp int4 NULL,
	hole3_par int4 NULL,
	hole4_dist int4 NULL,
	hole4_hdcp int4 NULL,
	hole4_par int4 NULL,
	hole5_dist int4 NULL,
	hole5_hdcp int4 NULL,
	hole5_par int4 NULL,
	hole6_dist int4 NULL,
	hole6_hdcp int4 NULL,
	hole6_par int4 NULL,
	hole7_dist int4 NULL,
	hole7_hdcp int4 NULL,
	hole7_par int4 NULL,
	hole8_dist int4 NULL,
	hole8_hdcp int4 NULL,
	hole8_par int4 NULL,
	hole9_dist int4 NULL,
	hole9_hdcp int4 NULL,
	hole9_par int4 NULL,
	rating float4 NOT NULL,
	slope int4 NOT NULL,
	course_pk int8 NULL,
	id int8 NOT NULL,
	"name" varchar(255) NOT NULL,
	CONSTRAINT tee_pkey PRIMARY KEY (id),
	CONSTRAINT tee_rating_check CHECK (((rating >= (60)::double precision) AND (rating <= (80)::double precision))),
	CONSTRAINT tee_slope_check CHECK (((slope <= 155) AND (slope >= 55))),
	CONSTRAINT fkpo9c5sihfferatbq2p66y7qgt FOREIGN KEY (course_pk) REFERENCES public.course(id)
);


-- public.score definition

-- Drop table

-- DROP TABLE public.score;

CREATE TABLE public.score (
	hole10_drive int4 NULL,
	hole10_fairway bool NULL,
	hole10_gir bool NULL,
	hole10_mulligans int4 NULL,
	hole10_penalties int4 NULL,
	hole10_putts int4 NULL,
	hole10_sandy bool NULL,
	hole10_strokes int4 NULL,
	hole11_drive int4 NULL,
	hole11_fairway bool NULL,
	hole11_gir bool NULL,
	hole11_mulligans int4 NULL,
	hole11_penalties int4 NULL,
	hole11_putts int4 NULL,
	hole11_sandy bool NULL,
	hole11_strokes int4 NULL,
	hole12_drive int4 NULL,
	hole12_fairway bool NULL,
	hole12_gir bool NULL,
	hole12_mulligans int4 NULL,
	hole12_penalties int4 NULL,
	hole12_putts int4 NULL,
	hole12_sandy bool NULL,
	hole12_strokes int4 NULL,
	hole13_drive int4 NULL,
	hole13_fairway bool NULL,
	hole13_gir bool NULL,
	hole13_mulligans int4 NULL,
	hole13_penalties int4 NULL,
	hole13_putts int4 NULL,
	hole13_sandy bool NULL,
	hole13_strokes int4 NULL,
	hole14_drive int4 NULL,
	hole14_fairway bool NULL,
	hole14_gir bool NULL,
	hole14_mulligans int4 NULL,
	hole14_penalties int4 NULL,
	hole14_putts int4 NULL,
	hole14_sandy bool NULL,
	hole14_strokes int4 NULL,
	hole15_drive int4 NULL,
	hole15_fairway bool NULL,
	hole15_gir bool NULL,
	hole15_mulligans int4 NULL,
	hole15_penalties int4 NULL,
	hole15_putts int4 NULL,
	hole15_sandy bool NULL,
	hole15_strokes int4 NULL,
	hole16_drive int4 NULL,
	hole16_fairway bool NULL,
	hole16_gir bool NULL,
	hole16_mulligans int4 NULL,
	hole16_penalties int4 NULL,
	hole16_putts int4 NULL,
	hole16_sandy bool NULL,
	hole16_strokes int4 NULL,
	hole17_drive int4 NULL,
	hole17_fairway bool NULL,
	hole17_gir bool NULL,
	hole17_mulligans int4 NULL,
	hole17_penalties int4 NULL,
	hole17_putts int4 NULL,
	hole17_sandy bool NULL,
	hole17_strokes int4 NULL,
	hole18_drive int4 NULL,
	hole18_fairway bool NULL,
	hole18_gir bool NULL,
	hole18_mulligans int4 NULL,
	hole18_penalties int4 NULL,
	hole18_putts int4 NULL,
	hole18_sandy bool NULL,
	hole18_strokes int4 NULL,
	hole1_drive int4 NULL,
	hole1_fairway bool NULL,
	hole1_gir bool NULL,
	hole1_mulligans int4 NULL,
	hole1_penalties int4 NULL,
	hole1_putts int4 NULL,
	hole1_sandy bool NULL,
	hole1_strokes int4 NULL,
	hole2_drive int4 NULL,
	hole2_fairway bool NULL,
	hole2_gir bool NULL,
	hole2_mulligans int4 NULL,
	hole2_penalties int4 NULL,
	hole2_putts int4 NULL,
	hole2_sandy bool NULL,
	hole2_strokes int4 NULL,
	hole3_drive int4 NULL,
	hole3_fairway bool NULL,
	hole3_gir bool NULL,
	hole3_mulligans int4 NULL,
	hole3_penalties int4 NULL,
	hole3_putts int4 NULL,
	hole3_sandy bool NULL,
	hole3_strokes int4 NULL,
	hole4_drive int4 NULL,
	hole4_fairway bool NULL,
	hole4_gir bool NULL,
	hole4_mulligans int4 NULL,
	hole4_penalties int4 NULL,
	hole4_putts int4 NULL,
	hole4_sandy bool NULL,
	hole4_strokes int4 NULL,
	hole5_drive int4 NULL,
	hole5_fairway bool NULL,
	hole5_gir bool NULL,
	hole5_mulligans int4 NULL,
	hole5_penalties int4 NULL,
	hole5_putts int4 NULL,
	hole5_sandy bool NULL,
	hole5_strokes int4 NULL,
	hole6_drive int4 NULL,
	hole6_fairway bool NULL,
	hole6_gir bool NULL,
	hole6_mulligans int4 NULL,
	hole6_penalties int4 NULL,
	hole6_putts int4 NULL,
	hole6_sandy bool NULL,
	hole6_strokes int4 NULL,
	hole7_drive int4 NULL,
	hole7_fairway bool NULL,
	hole7_gir bool NULL,
	hole7_mulligans int4 NULL,
	hole7_penalties int4 NULL,
	hole7_putts int4 NULL,
	hole7_sandy bool NULL,
	hole7_strokes int4 NULL,
	hole8_drive int4 NULL,
	hole8_fairway bool NULL,
	hole8_gir bool NULL,
	hole8_mulligans int4 NULL,
	hole8_penalties int4 NULL,
	hole8_putts int4 NULL,
	hole8_sandy bool NULL,
	hole8_strokes int4 NULL,
	hole9_drive int4 NULL,
	hole9_fairway bool NULL,
	hole9_gir bool NULL,
	hole9_mulligans int4 NULL,
	hole9_penalties int4 NULL,
	hole9_putts int4 NULL,
	hole9_sandy bool NULL,
	hole9_strokes int4 NULL,
	golfer_pk int8 NULL,
	id int8 NOT NULL,
	tee_pk int8 NULL,
	tee_time timestamp NULL,
	CONSTRAINT score_golfer_pk_tee_pk_tee_time_key UNIQUE (golfer_pk, tee_pk, tee_time),
	CONSTRAINT score_pkey PRIMARY KEY (id),
	CONSTRAINT fkb22le2v1wa6e3m4t72emfj6r7 FOREIGN KEY (tee_pk) REFERENCES public.tee(id),
	CONSTRAINT fkldw9849q9m50djqpjp37ymt52 FOREIGN KEY (golfer_pk) REFERENCES public.golfer(id)
);


-- public.scorecard_scores definition

-- Drop table

-- DROP TABLE public.scorecard_scores;

CREATE TABLE public.scorecard_scores (
	scorecard_id int8 NOT NULL,
	scores_id int8 NOT NULL,
	CONSTRAINT scorecard_scores_pkey PRIMARY KEY (scorecard_id, scores_id),
	CONSTRAINT scorecard_scores_scores_id_key UNIQUE (scores_id),
	CONSTRAINT fkmv441gs2l8596p17bf3g5gbcg FOREIGN KEY (scorecard_id) REFERENCES public.scorecard(id),
	CONSTRAINT fkq007s7hhoocg7n3eo9oqdwwnr FOREIGN KEY (scores_id) REFERENCES public.score(id)
);