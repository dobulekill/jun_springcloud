drop table if exists oauth_access_token;
create table oauth_access_token(
  token_id varchar(256) default null,
  token blob,
  authentication_id varchar (128) not null,
  user_name varchar (256) default null,
  client_id varchar (256) default null,
  authentication blob,
  refresh_token varchar (256) default null
)