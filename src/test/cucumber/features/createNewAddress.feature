Feature: Adding new address on my store website

  Scenario Outline: User can add an address to personal account
    Given User is logged in on my store website
    When Go through tiles to user addresses page
    Then Check if page is open on Address Page
    And Create address by filling forms with "<alias>" "<address>" "<zipPostalCode>" "<city>" "<country>" "<phone>"
    Then Added address should contain "<alias>" "<address>" "<zipPostalCode>" "<city>" "<country>" "<phone>"
    Then Added address should be deleted and the string should contain 'Address successfully deleted!'
    And close the browser

    Examples:
      | alias     | address               | zipPostalCode | city      | country         | phone               |
      | address 1 | Flower Street 12      | 00-100        | London    | United Kingdom  | 0998 8765 453 3543  |
      | address 2 | Random Square 30      | 00-997        | Dublin    | United Kingdom  | 9000 9000 8000 354  |