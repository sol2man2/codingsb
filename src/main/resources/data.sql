
insert into customer (name)
values ('kacey'), ('song');

insert into orders (customer_id)
values (1), (2);

insert into product (name)
values ('scrum'), ('kanban');

insert into item (orders_id, product_id)
values (1, 1), (1, 2);
