package br.com.fiap.postech.techchallenge.core.domain;


import br.com.fiap.postech.techchallenge.core.domain.enums.OrderStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseDomain {
    private List<Combo> combos = new ArrayList<>();
    private BigDecimal totalPrice = BigDecimal.ZERO;
    private OrderStatus orderStatus = OrderStatus.CREATED;
    private Customer customer;
    private LocalDateTime finishedTime;

    public void addCombo(Combo combo){
        combos.add(combo);
        increasePrice(combo.getTotalPrice());
    }

    public void removeCombo(Combo combo){
        combos.remove(combo);
        decreasePrice(combo.getTotalPrice());
    }

    public void updateOrderStatus(OrderStatus status){
        this.orderStatus = status;
        if(OrderStatus.FINISHED == status)
            updateFinishedTime();
    }

    public List<Combo> getCombos(){
        return Collections.unmodifiableList(combos);
    }

    public BigDecimal getTotalPrice(){
        return BigDecimal.valueOf(totalPrice.doubleValue());
    }

    private void increasePrice(BigDecimal price){
        this.totalPrice = totalPrice.add(price);
    }

    private void decreasePrice(BigDecimal price){
        this.totalPrice = totalPrice.subtract(price);
    }

    private void updateFinishedTime(){
        this.finishedTime = LocalDateTime.now();
    }

    public String getEstimatedTime(){
        Duration duration = combos.stream()
                .map(combo -> combo.getProduct().getEstimatedTime())
                .max(Comparator.naturalOrder())
                .orElse(Duration.ZERO);

        long seconds = duration.getSeconds();

        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long secs = seconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }

}
