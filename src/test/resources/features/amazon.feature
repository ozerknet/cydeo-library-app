Feature:Amazon dan belli urunu sepete atma

  @wip
  Scenario: Amazon

    When Amazona gir
    And Kategori olarak book sec
    And Search kismina harry potter yaz
    And Search butonuna bas
    And Cikan sonucta ilk elemanin harry potter ismini icerdigini dogrula
    And Fiyatin "6" oldugunu dogrula
    And Turun paperback oldugunu dogrula
    And Add to basket yap
#    And Baskette 1 item oldugunu dogrula.