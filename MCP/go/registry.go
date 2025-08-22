package main

import (
	"github.com/klarna-payments-api-v1/mcp-server/config"
	"github.com/klarna-payments-api-v1/mcp-server/models"
	tools_sessions "github.com/klarna-payments-api-v1/mcp-server/tools/sessions"
	tools_orders "github.com/klarna-payments-api-v1/mcp-server/tools/orders"
)

func GetAll(cfg *config.APIConfig) []models.Tool {
	return []models.Tool{
		tools_sessions.CreateCreatecreditsessionTool(cfg),
		tools_sessions.CreateReadcreditsessionTool(cfg),
		tools_sessions.CreateUpdatecreditsessionTool(cfg),
		tools_orders.CreateCancelauthorizationTool(cfg),
		tools_orders.CreatePurchasetokenTool(cfg),
		tools_orders.CreateCreateorderTool(cfg),
	}
}
