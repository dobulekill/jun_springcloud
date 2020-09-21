drop table if exists oauth_approvals;
create table oauth_approvals(
  userId varchar(256) default null,
  clientId varchar(256) default null,
  scope varchar(256) default null,
  expiresAt datetime default null,
  lastModitiedAt datetime default null
)