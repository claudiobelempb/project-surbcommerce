package br.surb.com.br.dscommerce.mapper;

import br.surb.com.br.dscommerce.dto.category.CategoryResponse;
import br.surb.com.br.dscommerce.dto.product.*;
import br.surb.com.br.dscommerce.entities.Category;
import br.surb.com.br.dscommerce.entities.Product;

import java.util.stream.Collectors;

public final class ProductMapper {
    public static Product toRequest(ProductRequest request) {
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .price(request.price())
                .description(request.description())
                .build();
    }

    public static ProductResponse toResponse(Product entity) {
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getImgUrl()
        );
    }

    public static Product toCreateRequest(ProductCreateRequest request) {
        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .imgUrl(request.imgUrl())
                .categories(request.categories().stream().map(response -> Category.builder().id(response.id()).name(response.name()).build()).collect(Collectors.toSet()))
                .build();
    }

    public static ProductCreateResponse toCreateResponse(Product entity) {
        return new ProductCreateResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getImgUrl(),
                entity.getCategories().stream().map(category -> new CategoryResponse(category.getId(), category.getName())).collect(Collectors.toSet())
        );
    }

    public static Product toCustomRequest(ProductCustomRequest request) {
        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .imgUrl(request.imgUrl())
                .categories(request.categories().stream().map(response -> Category.builder().id(response.id()).name(response.name()).build()).collect(Collectors.toSet()))
                .build();
    }

    public static ProductCustomResponse toCustomResponse(Product entity) {
        return new ProductCustomResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getImgUrl(),
                entity.getCategories().stream().map(category -> new CategoryResponse(category.getId(), category.getName())).collect(Collectors.toSet())
        );
    }

}
