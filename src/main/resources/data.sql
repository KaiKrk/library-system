--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 12.0

-- Started on 2020-04-20 01:13:23

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2833 (class 0 OID 34415)
-- Dependencies: 197
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.book (book_id, author, category, copies_book, name) FROM stdin;
1	James Smith	Fantasy	20	Tales Of James
2	John Doe	Drame	100	Drame de John
3	Paul Doe	Fantasy	45	Fairy Tales of Paul
8	Sam Doe	Fantasy	0	Fairy Tales of Sam
4	Paul Doe	Fantasy	0	Les Paroles De L'Élément
6	Jean Doe	Fantasy	45	Les Manuscrits De Xecdarr
10	Beckett Rosario	Thriller	12	La Chronique De La Conception
11	Beckett Rosario	Thriller	5	Le Testament D'yflena
14	Charlotte Mcguire	Enfance	3	Le Livre D'urasil
16	John Pittman	Enfance	4	La Parole Du Protecteur
9	Jean Bern	Compte	19	La Chronique Des Natthys
15	Valentina Hamilton	Enfance	3	Le Livre De Générations
12	Eric Larson	Drame	3	Les Histoires D'Enseignements
13	Eric Larson	Drame	6	La Parole De Sendon
\.


--
-- TOC entry 2837 (class 0 OID 34437)
-- Dependencies: 201
-- Data for Name: booking; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.booking (booking_id, member_id, book_id, borrowing_date, return_date, renewable, status) FROM stdin;
4	1	3	2020-03-28	2020-04-28	f	Prolongee
8	1	9	2020-03-31	2020-05-01	f	Prolongee
9	4	15	2020-04-06	2020-05-06	t	Actif
10	4	12	2020-02-06	2020-03-06	t	Actif
11	4	13	2020-03-18	2020-04-18	t	Actif
\.


--
-- TOC entry 2835 (class 0 OID 34426)
-- Dependencies: 199
-- Data for Name: member; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.member (member_id, name, email, password, surname, admin) FROM stdin;
1	John	JS@email.fr	$2a$10$YC1Tr/FTdq3844luPcnR1OFtwDodJW4ZIfDM/UYtaNUJeOTh51zUC	Smith	f
2	John	JohnD@email.fr	$2a$10$fSJ.hwlIKdXzYwC0lIvyeevhkzShQTRwvw8fq/OFbHSmqGSDsUYxa	Doe	f
3	Anna	annalibraryoc@gmail.com	$2a$10$Djo8zB6BspdmYRaTOYweC.ruygHhme6qyxfTU/3Ta12Vj4pJxCvLW	Harrison	t
4	Jack	jackp7opc@yopmail.com	$2a$10$u8o6J6zXUiWglIzQ86ti.O6ZNDOq21r8dhesbrZXm8O24UfcXnliS	Scott	f
5	Carl	carllevisp7@yopmail.com	$2a$10$TQyI0N9xilyh9IULE1YGdewg596d3cO2nfQVd2z84OYA4ozGyP81a	Levis	f
\.


--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 196
-- Name: book_book_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.book_book_id_seq', 16, true);


--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 200
-- Name: booking_booking_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.booking_booking_id_seq', 11, true);


--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 198
-- Name: member_member_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.member_member_id_seq', 5, true);


-- Completed on 2020-04-20 01:13:24

--
-- PostgreSQL database dump complete
--

