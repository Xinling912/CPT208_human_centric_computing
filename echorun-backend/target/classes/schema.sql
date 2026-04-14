-- 可选：手动建表参考（若关闭 ddl-auto 或需要初始化脚本时可使用）
CREATE TABLE IF NOT EXISTS user_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(64) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS run_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    started_at TIMESTAMP NULL,
    ended_at TIMESTAMP NULL,
    distance_meters DOUBLE NULL,
    duration_seconds INT NULL,
    trajectory_json JSON NOT NULL,
    CONSTRAINT fk_run_user FOREIGN KEY (user_id) REFERENCES user_info (id)
);

-- 若从旧版「run_trajectory 子表」迁移，可执行（按需调整）：
-- ALTER TABLE run_record ADD COLUMN trajectory_json JSON NOT NULL;
-- 将子表数据合并写入 trajectory_json 后：
-- DROP TABLE IF EXISTS run_trajectory;
