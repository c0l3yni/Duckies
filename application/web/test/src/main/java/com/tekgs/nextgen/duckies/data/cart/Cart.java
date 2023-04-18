package com.tekgs.nextgen.duckies.data.cart;

import com.tekgs.nextgen.duckies.behavior.ToStringBehavior;
import com.tekgs.nextgen.duckies.data.cart.item.CartItemCalibratable;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Cart implements CartCalibratable {
    private transient final ToStringBehavior toStringBehavior = ToStringBehavior.getInstance(this);
    private String id;
    private List<CartItemCalibratable> items;
    @SuppressWarnings("FieldCanBeLocal")
    private Integer total;

    public CartDefinition toDefinition() {
        return CartDefinition.getInstance().withItems(items);
    }

    public boolean equivalent(CartCalibratable comparator) {
        if (comparator == null) {
            return false;
        } else if (this.getId().equals(comparator.getId())) {
            return true;
        }
        boolean isEquivalent = comparator.getTotal() == null || this.getTotal().equals(comparator.getTotal());
        isEquivalent &= comparator.isEmpty() == null || this.isEmpty().equals(comparator.isEmpty());
        isEquivalent &= areEquivalent(comparator.getItems());
        return isEquivalent;
    }

    private boolean areEquivalent(List<CartItemCalibratable> comparatorItems) {
        List<CartItemCalibratable> workingList = new ArrayList<>(this.getItems());
        for (CartItemCalibratable comparator : comparatorItems) {
            CartItemCalibratable foundItem = null;
            for (CartItemCalibratable candidate : workingList) {
                if (candidate.equivalent(comparator)) {
                    foundItem = candidate;
                    workingList.remove(candidate);
                    break;
                }
            }
            if (foundItem == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Integer getTotal() {
        this.total = 0;
        for (CartItemCalibratable item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    @Override
    public Boolean isEmpty() {
        return items.size() == 0;
    }

    @Override
    public List<CartItemCalibratable> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return toStringBehavior.execute();
    }
}
