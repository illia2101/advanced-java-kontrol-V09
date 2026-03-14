package ua.university.process;

import ua.university.OrderStatus;
import ua.university.domain.Order;
import ua.university.exception.FraudCheckFailedException;
import java.util.logging.Logger;

public abstract class OrderProcessorTemplate {
    private static final Logger log = Logger.getLogger(OrderProcessorTemplate.class.getName());

    public final void process(Order order ){
        log.info("Start processing order: " + order.getId());
        try {
            validate(order);
            fraudCheck(order);
            calculate(order);
            pay(order);
            finish(order);
        }catch (FraudCheckFailedException e){
            log.warning("Fraud check failed" + e.getMessage());
            throw e;
        }

        catch (Exception ex){
            log.severe("Unexpected error processing order: " + ex.getMessage());
        }
    }
    protected abstract void validate(Order order);
    protected abstract void calculate(Order order);
    protected abstract void pay(Order order);
    protected void fraudCheck(Order order){
        if (Math.random() < 0.05) {
            throw new FraudCheckFailedException("Fraud detected");
        }

    }
    protected void finish(Order order) {
        order.setStatus(OrderStatus.PAID);
    }

}
