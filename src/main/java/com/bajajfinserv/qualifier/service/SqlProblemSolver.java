package com.bajajfinserv.qualifier.service;

import org.springframework.stereotype.Service;

@Service
public class SqlProblemSolver {
    
    /**
     * Determines which SQL question to solve based on regNo
     * Odd last two digits -> Question 1
     * Even last two digits -> Question 2
     */
    public String getSqlSolution(String regNo) {
        int lastTwoDigits = Integer.parseInt(regNo.substring(regNo.length() - 2));
        
        if (lastTwoDigits % 2 == 1) {
            // Question 1 - Odd regNo ending
            return getQuestion1Solution();
        } else {
            // Question 2 - Even regNo ending
            return getQuestion2Solution();
        }
    }
    
    private String getQuestion1Solution() {
        // Placeholder solution for Question 1
        // This would contain the actual SQL query after analyzing the problem
        // Common SQL problems in such assessments include:
        // - Finding top/bottom records
        // - Joining tables
        // - Aggregations with GROUP BY
        // - Window functions
        
        return "SELECT e.employee_id, e.name, e.department, e.salary " +
               "FROM employees e " +
               "INNER JOIN departments d ON e.department_id = d.department_id " +
               "WHERE e.salary > (SELECT AVG(salary) FROM employees) " +
               "ORDER BY e.salary DESC";
    }
    
    private String getQuestion2Solution() {
        // Placeholder solution for Question 2
        return "SELECT customer_id, customer_name, " +
               "SUM(order_amount) as total_orders, " +
               "COUNT(*) as order_count " +
               "FROM orders " +
               "WHERE order_date >= '2023-01-01' " +
               "GROUP BY customer_id, customer_name " +
               "HAVING COUNT(*) > 5 " +
               "ORDER BY total_orders DESC";
    }
}
