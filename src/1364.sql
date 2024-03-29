select
      invoice_id,
      customer_name,
      price,
      ifnull(contacts_cnt, 0) contacts_cnt,
      ifnull(trusted_contacts_cnt, 0) trusted_contacts_cnt
from
      (
            select
                  invoice_id,
                  price,
                  user_id,
                  customer_name
            from
                  Invoices
                  left join Customers on Customers.customer_id = Invoices.user_id
      ) mid
      left join (
            select
                  Contacts.user_id,
                  sum(if(mid2.user_id is null, 0, 1)) trusted_contacts_cnt,
                  count(Contacts.user_id) contacts_cnt
            from
                  Contacts
                  left join (
                        select
                              user_id,
                              contact_email
                        from
                              Contacts
                        where
                              contact_email in (
                                    select
                                          email
                                    from
                                          Customers
                              )
                  ) mid2 on mid2.user_id = Contacts.user_id
                  and mid2.contact_email = Contacts.contact_email
            group by
                  user_id
      ) mid3 on mid.user_id = mid3.user_id
order by
      invoice_id;