package query;

public class QueryExample {
    public static void main(String[] args) {
        // Executing the named query
//        List<Product> products = entityManager.createNamedQuery("Product.findByPrice", Product.class)
//                .setParameter("price", 100)
//                .getResultList();

//
//        TypedQuery<Product> typedQuery = entityManager.createQuery("SELECT p FROM Product p", Product.class);
//        List<Product> products = typedQuery.getResultList();

//        String sqlQuery = "SELECT * FROM Product WHERE price >= :minPrice AND price <= :maxPrice";
//        List<Product> productList = entityManager.createNativeQuery(sqlQuery, Product.class)
//                .setParameter("minPrice", minPrice)
//                .setParameter("maxPrice", maxPrice)
//                .getResultList();

        // Executing the named native query
//        List<Product> productList = entityManager.createNamedQuery("Product.findByPriceRange", Product.class)
//                .setParameter("minPrice", minPrice)
//                .setParameter("maxPrice", maxPrice)
//                .getResultList();
    }
}
