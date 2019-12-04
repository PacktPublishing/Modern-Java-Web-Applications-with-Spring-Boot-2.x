--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

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

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: basket; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.basket (
    id numeric(5,0) NOT NULL,
    hid numeric(5,0) NOT NULL,
    userid numeric(5,0) NOT NULL,
    purchased_date date NOT NULL,
    approved_date date NOT NULL,
    qty numeric(5,0) NOT NULL,
    approved_by character varying(100) NOT NULL
);


ALTER TABLE public.basket OWNER TO postgres;

--
-- Name: harvest; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.harvest (
    id numeric(5,0) NOT NULL,
    name character varying(20) NOT NULL,
    qty numeric(10,0) NOT NULL,
    price numeric(10,3) NOT NULL,
    status character(10) NOT NULL,
    type character(10) NOT NULL,
    approved date NOT NULL,
    description character varying(100) NOT NULL
);


ALTER TABLE public.harvest OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: location; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.location (
    id numeric(5,0) NOT NULL,
    name character varying(20) NOT NULL,
    owner character varying(50) NOT NULL,
    delivery_date date NOT NULL,
    hid numeric NOT NULL
);


ALTER TABLE public.location OWNER TO postgres;

--
-- Name: login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.login (
    id numeric(5,0) NOT NULL,
    username character(20) NOT NULL,
    passphrase character(100),
    password character varying(20) NOT NULL,
    user_id numeric
);


ALTER TABLE public.login OWNER TO postgres;

--
-- Name: TABLE login; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.login IS 'login information';


--
-- Name: permission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.permission (
    id numeric(5,0) NOT NULL,
    name character varying(20) NOT NULL,
    description character varying(50) NOT NULL
);


ALTER TABLE public.permission OWNER TO postgres;

--
-- Name: permission_sets; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.permission_sets (
    id numeric(5,0) NOT NULL,
    login_id numeric(5,0) NOT NULL,
    perm_id numeric(5,0) NOT NULL,
    role_id numeric(5,0) NOT NULL
);


ALTER TABLE public.permission_sets OWNER TO postgres;

--
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id numeric(5,0) NOT NULL,
    name character varying(20) NOT NULL,
    description character varying(50) NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- Name: signup; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.signup (
    address character varying(200) NOT NULL,
    approved boolean NOT NULL,
    email character(20) NOT NULL,
    id numeric(5,0) NOT NULL,
    mobile character(15) NOT NULL,
    name character varying(50) NOT NULL,
    password character(20) NOT NULL,
    username character(20) NOT NULL,
    birthday date
);


ALTER TABLE public.signup OWNER TO postgres;

--
-- Name: TABLE signup; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.signup IS 'For Signup Request Transactions';


--
-- Data for Name: basket; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.basket (id, hid, userid, purchased_date, approved_date, qty, approved_by) FROM stdin;
\.


--
-- Data for Name: harvest; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.harvest (id, name, qty, price, status, type, approved, description) FROM stdin;
101	Bittergurd	1000	50.900	fresh     	vegetable 	2019-10-15	Small and fresh
201	Apple	6000	90.900	amorous   	fruits    	2019-10-15	Red and Fresh
345	Mine	890	1900.000	new       	Fruits    	2019-10-22	Fresh
\.


--
-- Data for Name: location; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.location (id, name, owner, delivery_date, hid) FROM stdin;
445	Farmer's Plaza	Mine	2019-10-22	345
\.


--
-- Data for Name: login; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.login (id, username, passphrase, password, user_id) FROM stdin;
201	sjctrags            	$argon2id$v=19$m=4096,t=3,p=1$4KcBBvYhCJsnSP6cvHu8Tg$mMrwyxLSWmFAaQDn0DqwmjNsNM5Ay3pmhLe4IdE5c60    	sjctrags	101
202	owen                	$argon2id$v=19$m=4096,t=3,p=1$biY73dU9wLBOVaECLUcjyg$eHsP4jTpCNuMPOgD6QyMkHoxJbupW9W+dFaMWK2ahS4    	owen	102
\.


--
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.permission (id, name, description) FROM stdin;
0	READ	Retrieve data
1	UPDATE	Update records
2	DELETE	Delete records
3	ADD	Insert new records
4	ENDPOINT	ACTUATOR ACCESS
\.


--
-- Data for Name: permission_sets; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.permission_sets (id, login_id, perm_id, role_id) FROM stdin;
0	201	0	0
1	201	1	1
2	202	1	2
3	201	4	0
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (id, name, description) FROM stdin;
0	ADMIN	Administration
1	USER	Customer
2	GUEST	Visitor
\.


--
-- Data for Name: signup; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.signup (address, approved, email, id, mobile, name, password, username, birthday) FROM stdin;
Makati	t	sjctrags@gmail.com  	103	4535454        	sjctrags	love                	love                	1980-11-11
Makati	t	sjctrags@gmail.com  	104	4535454        	sjctrags	hate                	hate                	1980-11-11
Makati	t	sjctrags@gmail.com  	109	4535454        	sjctrags	crye@@22            	coverye             	1980-11-11
Makati	t	jgrey@gmail.com     	200	45945894       	Jean Grey	grey                	jeangrey            	2019-10-15
Makati	t	sjctrags@gmail.com  	110	4535454        	sjctrags	matt                	matt                	1980-11-11
Manila	t	sjctrags@gmail.com  	101	43545454       	Michael Johnson	sjctrags            	sjctrags            	1978-10-20
Makati	t	sjctrags@gmail.com  	102	4535454        	sjctrags	owen                	owen                	1980-11-11
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 41, true);


--
-- Name: basket basket_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.basket
    ADD CONSTRAINT basket_pkey PRIMARY KEY (id);


--
-- Name: harvest harvest_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.harvest
    ADD CONSTRAINT harvest_pkey PRIMARY KEY (id);


--
-- Name: location location_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT location_pkey PRIMARY KEY (id);


--
-- Name: login login_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_pkey PRIMARY KEY (id);


--
-- Name: permission permission_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permission
    ADD CONSTRAINT permission_pkey PRIMARY KEY (id);


--
-- Name: permission_sets permission_sets_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permission_sets
    ADD CONSTRAINT permission_sets_pkey PRIMARY KEY (id);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: signup signup_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.signup
    ADD CONSTRAINT signup_pkey PRIMARY KEY (id);


--
-- Name: login uk_3svxcq6q51yfdg253l6x3dget; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login
    ADD CONSTRAINT uk_3svxcq6q51yfdg253l6x3dget UNIQUE (username);


--
-- Name: signup username_uk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.signup
    ADD CONSTRAINT username_uk UNIQUE (username);


--
-- Name: basket basket_hid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.basket
    ADD CONSTRAINT basket_hid_fkey FOREIGN KEY (hid) REFERENCES public.harvest(id);


--
-- Name: basket basket_userid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.basket
    ADD CONSTRAINT basket_userid_fkey FOREIGN KEY (userid) REFERENCES public.login(id);


--
-- Name: permission_sets loginFk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permission_sets
    ADD CONSTRAINT "loginFk" FOREIGN KEY (login_id) REFERENCES public.login(id);


--
-- Name: permission_sets permissionFk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permission_sets
    ADD CONSTRAINT "permissionFk" FOREIGN KEY (perm_id) REFERENCES public.permission(id);


--
-- Name: location product_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT product_fk FOREIGN KEY (hid) REFERENCES public.harvest(id);


--
-- Name: permission_sets roleFk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permission_sets
    ADD CONSTRAINT "roleFk" FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- Name: login username_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login
    ADD CONSTRAINT username_fk FOREIGN KEY (username) REFERENCES public.signup(username);


--
-- PostgreSQL database dump complete
--

