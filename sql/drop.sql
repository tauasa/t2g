
/* clobberit all */

DROP TABLE if exists public.scorecard_scores CASCADE;
DROP TABLE if exists public.scorecard CASCADE;
DROP TABLE if exists public.score CASCADE;
DROP TABLE if exists public.golfer CASCADE;
DROP TABLE if exists public.tee CASCADE;
DROP TABLE if exists public.course CASCADE;

DROP SEQUENCE if exists public.course_seq;
DROP SEQUENCE if exists public.golfer_seq;
DROP SEQUENCE if exists public.score_seq;
DROP SEQUENCE if exists public.scorecard_seq;
DROP SEQUENCE if exists public.tee_seq;



